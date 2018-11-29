package client.services.manager;

import client.ChatClient;
import client.model.packet.request.RegisterUserRequestPacket;

public class RegisterUserRequestManager {
    RegisterUserRequestPacket registerUserRequestPacket = new RegisterUserRequestPacket();
    private static RegisterUserRequestManager INSTANCE = new RegisterUserRequestManager();
    public RegisterUserRequestManager() {
    }

    public static RegisterUserRequestManager getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(RegisterUserRequestManager INSTANCE) {
        RegisterUserRequestManager.INSTANCE = INSTANCE;
    }

    public void sendRegisterUserRequestPacket(String username, String password, String sign, String telephone){
        registerUserRequestPacket.setUsername(username);
        registerUserRequestPacket.setPassword(password);
        registerUserRequestPacket.setSign(sign);
        registerUserRequestPacket.setPhone(telephone);
        ChatClient.channel.writeAndFlush(registerUserRequestPacket);
    }
}
