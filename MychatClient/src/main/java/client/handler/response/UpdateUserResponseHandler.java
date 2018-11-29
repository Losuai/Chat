package client.handler.response;

import client.application.RegisterMessageViewApplication;
import client.global.CommonSwitchStage;
import client.model.packet.response.UpdateUserResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import javafx.stage.Stage;

public class UpdateUserResponseHandler extends SimpleChannelInboundHandler<UpdateUserResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, UpdateUserResponsePacket responsePacket) throws Exception {
        if (responsePacket.isSuccess()){
            Platform.runLater(() -> {
                //创建主界面窗口
                new RegisterMessageViewApplication().start(new Stage());
                CommonSwitchStage.registerMessageViewController.setText(responsePacket.getReason());
            });
            System.out.println("成功");
        }else{
            Platform.runLater(() -> {
                //创建主界面窗口
                new RegisterMessageViewApplication().start(new Stage());
                CommonSwitchStage.registerMessageViewController.setText(responsePacket.getReason());
            });
            System.out.println("失败"+responsePacket.getReason());
        }
    }
}
