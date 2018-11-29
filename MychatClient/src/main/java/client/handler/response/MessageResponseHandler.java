package client.handler.response;

import client.global.CommonSwitchStage;
import client.model.packet.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageResponsePacket responsePacket) throws Exception {
        CommonSwitchStage.chatRoomViewController.writeMes(responsePacket.getFromUserName(),responsePacket.getMessage());
    }
}
