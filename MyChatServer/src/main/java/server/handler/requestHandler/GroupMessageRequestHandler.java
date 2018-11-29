package server.handler.requestHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import server.model.packet.request.GroupMessageRequestPacket;
import server.model.packet.response.GroupMessageResponsePacket;
import server.model.user.UserEntity;
import server.repository.UserRepository;
import server.utils.common.SessionUtil;

import java.util.List;

public class GroupMessageRequestHandler extends SimpleChannelInboundHandler<GroupMessageRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageRequestPacket RequestPacket) throws Exception {
        GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket();
        UserRepository userRepository = new UserRepository();
        groupMessageResponsePacket.setMessage(RequestPacket.getMessage());
        groupMessageResponsePacket.setFromUser(SessionUtil.getSession(ctx.channel()));
        System.out.println("接受到群消息");
        List<UserEntity> userEntityList = userRepository.findAllUser();
        for (UserEntity user:userEntityList
             ) {
            Integer userId = user.getId();
            if (SessionUtil.getChannel(userId.toString()) != null && SessionUtil.getChannel(userId.toString()) != ctx.channel() ){
                SessionUtil.getChannel(userId.toString()).writeAndFlush(groupMessageResponsePacket);
            }
        }

        System.out.println("发送群消息！！");
    }
}
