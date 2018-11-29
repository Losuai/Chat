package client.handler.response;

import client.global.CommonSwitchStage;
import client.model.User;
import client.model.packet.response.FriendsListResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

import java.util.List;

public class FriendsListResponseHandler extends SimpleChannelInboundHandler<FriendsListResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FriendsListResponsePacket responsePacket) throws Exception {

    }
}
