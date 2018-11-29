package client.services.manager;

import client.ChatClient;
import client.model.packet.request.UpdateUserRequestPacket;

public class UpdateUserRequestManager {
    private static UpdateUserRequestManager INSTANCE = new UpdateUserRequestManager();

    public UpdateUserRequestManager() {
    }

    public static UpdateUserRequestManager getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(UpdateUserRequestManager INSTANCE) {
        UpdateUserRequestManager.INSTANCE = INSTANCE;
    }

    public void sendUpdateUser(String username,String lastUsernaem,String password,String newPassword,String sign,String phone){
        UpdateUserRequestPacket updateUserRequestPacket = new UpdateUserRequestPacket();
        updateUserRequestPacket.setUsername(username);
        updateUserRequestPacket.setPassword(password);
        updateUserRequestPacket.setNewPassword(newPassword);
        updateUserRequestPacket.setSign(sign);
        updateUserRequestPacket.setPhone(phone);
        updateUserRequestPacket.setLastUsername(lastUsernaem);
        ChatClient.channel.writeAndFlush(updateUserRequestPacket);
    }
}
