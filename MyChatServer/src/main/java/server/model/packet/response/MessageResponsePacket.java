package server.model.packet.response;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.MESSAGE_RESPONSE;

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
