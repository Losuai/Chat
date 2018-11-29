package client.model.packet.request;

import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.GROUP_MESSAGE_REQUEST;


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
