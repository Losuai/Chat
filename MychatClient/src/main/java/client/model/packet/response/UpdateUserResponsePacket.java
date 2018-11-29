package client.model.packet.response;

import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.UPDATE_USER_RESPONSE;
@Data
public class UpdateUserResponsePacket extends Packet {
    private String reason;
    private boolean success;

    @Override
    public Byte getCommand() {
        return UPDATE_USER_RESPONSE;
    }
}
