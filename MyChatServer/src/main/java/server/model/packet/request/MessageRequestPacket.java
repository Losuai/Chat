package server.model.packet.request;

import lombok.Data;
import server.model.Packet;
@Data
public class MessageRequestPacket extends Packet {
    private String toUserName;
    private String message;
    @Override
    public Byte getCommand() {
        return null;
    }
    
}
