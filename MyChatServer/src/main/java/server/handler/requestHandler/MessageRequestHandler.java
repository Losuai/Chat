package server.handler.requestHandler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import server.model.packet.request.MessageRequestPacket;
import server.model.packet.response.MessageResponsePacket;
import server.model.session.Session;
import server.model.user.UserEntity;
import server.repository.UserRepository;
import server.utils.common.SessionUtil;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket requestPacket) throws Exception {
        Session session = SessionUtil.getSession(ctx.channel());
        System.out.println("消息");
        UserRepository userRepository = new UserRepository();
        UserEntity user = userRepository.findUserByName(requestPacket.getToUserName());
        // 2.通过消息发送方的会话信息构造要发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUsername());
        messageResponsePacket.setMessage(requestPacket.getMessage());
        Integer userId = user.getId();
        // 3.拿到消息接收方的 channel
        Channel toUserChannel = SessionUtil.getChannel(userId.toString());
        // 4.将消息发送给消息接收方
        if (toUserChannel != null && SessionUtil.hasLogin(toUserChannel)) {
            toUserChannel.writeAndFlush(messageResponsePacket);
        } else {
            System.err.println("[" + requestPacket.getToUserName() + "] 不在线，发送失败!");
        }
    }
}
