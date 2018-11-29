package server.model.packet.response;

import lombok.Data;
import server.model.Packet;
import server.model.session.Session;

import static server.utils.command.GROUP_MESSAGE_RESPONSE;
@Data
public class GroupMessageResponsePacket extends Packet {
    private Session fromUser;
    private String message;

    public GroupMessageResponsePacket() {
    }

    public GroupMessageResponsePacket(Session fromUser, String message) {
        this.fromUser = fromUser;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_RESPONSE;
    }
}
