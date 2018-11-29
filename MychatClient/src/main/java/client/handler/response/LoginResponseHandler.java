package client.handler.response;

import client.application.IndexApplication;
import client.application.LoginApplication;
import client.application.RegisterMessageViewApplication;
import client.global.CommonSwitchStage;
import client.model.packet.response.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import javafx.application.Platform;
import javafx.stage.Stage;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket responsePacket) throws Exception {
        System.out.println(responsePacket.isSuccess());
        if (responsePacket.isSuccess()){
            System.out.println("ok");
            Platform.runLater(() -> {
            //创建主界面窗口
                new IndexApplication().start(new Stage());
                CommonSwitchStage.indexViewController.write(responsePacket.getUserName(),responsePacket.getPhone(),responsePacket.getSign());

        });

        }else{
            Platform.runLater(() -> {
                //创建主界面窗口
                new RegisterMessageViewApplication().start(new Stage());
                CommonSwitchStage.registerMessageViewController.setText(responsePacket.getReason());
            });
            System.out.println("bad");

        }
    }
}
