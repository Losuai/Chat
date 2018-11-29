package client.handler.response;

import client.global.CommonSwitchStage;
import client.model.packet.response.GroupMessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;




public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {
    public GroupMessageResponseHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket responsePacket) throws Exception {
        GroupMessageResponsePacket groupMessageResponsePacket = new GroupMessageResponsePacket();
        groupMessageResponsePacket.setMessage(responsePacket.getMessage());
        groupMessageResponsePacket.setFromUser(responsePacket.getFromUser());
        groupMessageResponsePacket.getFromUser().getUsername();
        System.out.println(groupMessageResponsePacket.getMessage());
        CommonSwitchStage.indexViewController.wirteMsg(groupMessageResponsePacket.getFromUser().getUsername(),groupMessageResponsePacket.getMessage());
    }
}
