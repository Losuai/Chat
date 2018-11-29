package server.model.packet.request;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.GROUP_MESSAGE_REQUEST;

@Data
public class GroupMessageRequestPacket extends Packet {
    private String message;

    public GroupMessageRequestPacket(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
