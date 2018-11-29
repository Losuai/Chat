package client.model.packet.response;

import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.MESSAGE_RESPONSE;
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;
    private String fromUserName;
    private String message;
    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
