package client.model.packet.response;

import client.model.session.Session;
import client.utils.common.Packet;
import lombok.Data;
import static client.utils.command.GROUP_MESSAGE_RESPONSE;

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
