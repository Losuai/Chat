package client.services.manager;

import client.ChatClient;
import client.model.packet.request.MessageRequestPacket;

public class MessageRequestManager {
    private static MessageRequestManager messageRequestManager = new MessageRequestManager();

    public static MessageRequestManager getMessageRequestManager() {
        return messageRequestManager;
    }

    public static void setMessageRequestManager(MessageRequestManager messageRequestManager) {
        MessageRequestManager.messageRequestManager = messageRequestManager;
    }

    public void sendMessage(String username, String message){
        MessageRequestPacket messageRequestPacket = new MessageRequestPacket();
        messageRequestPacket.setMessage(message);
        messageRequestPacket.setToUserName(username);
        ChatClient.channel.writeAndFlush(messageRequestPacket);

    }
}
