package client.services.manager;

import client.ChatClient;
import client.model.packet.request.LoginRequestPacket;

public class LoginRequestManager {
    private static LoginRequestManager INSTANCE = new LoginRequestManager();
    LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
    public LoginRequestManager() {
    }
    public static LoginRequestManager getINSTANCE() {
        return INSTANCE;
    }
    public void sendRequestPacket(String username,String password){
        loginRequestPacket.setUsername(username);
        loginRequestPacket.setPassword(password);
        ChatClient.channel.writeAndFlush(loginRequestPacket);
    }
}
