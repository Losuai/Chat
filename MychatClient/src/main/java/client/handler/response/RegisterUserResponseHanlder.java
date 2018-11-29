package client.handler.response;

import client.application.RegisterMessageViewApplication;
import client.global.CommonSwitchStage;
import client.model.packet.response.RegisterUserResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import javafx.stage.Stage;

public class RegisterUserResponseHanlder extends SimpleChannelInboundHandler<RegisterUserResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterUserResponsePacket responsePacket) throws Exception {
        if (responsePacket.isSuccess()){
            Platform.runLater(() -> {
                //创建主界面窗口
                new RegisterMessageViewApplication().start(new Stage());
                CommonSwitchStage.registerMessageViewController.setText(responsePacket.getReason());
            });
            System.out.println("注册成功");
        }else{
            Platform.runLater(() -> {
                //创建主界面窗口
                new RegisterMessageViewApplication().start(new Stage());
                CommonSwitchStage.registerMessageViewController.setText(responsePacket.getReason());
            });

            System.out.println("注册失败"+responsePacket.getReason());
        }
    }
}
