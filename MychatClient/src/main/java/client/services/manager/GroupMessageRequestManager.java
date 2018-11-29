package client.services.manager;

import client.ChatClient;
import client.model.packet.request.GroupMessageRequestPacket;

public class GroupMessageRequestManager {
    private static GroupMessageRequestManager INSTANCE = new GroupMessageRequestManager();

    public GroupMessageRequestManager() {
    }
    public static GroupMessageRequestManager getINSTANCE() {
        return INSTANCE;
    }
    public void sendMessage(String message){
        GroupMessageRequestPacket groupMessageRequestPacket = new GroupMessageRequestPacket(message);
        ChatClient.channel.writeAndFlush(groupMessageRequestPacket);
    }
}
