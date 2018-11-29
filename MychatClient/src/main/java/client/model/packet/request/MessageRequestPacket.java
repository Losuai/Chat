package client.model.packet.request;


import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.MESSAGE_REQUEST;
@Data
public class MessageRequestPacket extends Packet {
    private String toUserName;
    private String message;
    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
