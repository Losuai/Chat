package server.model.packet.response;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.UPDATE_USER_RESPONSE;

@Data
public class UpdateUserResponsePacket extends Packet {
    private String reason;
    private boolean success;

    @Override
    public Byte getCommand() {
        return UPDATE_USER_RESPONSE;
    }
}
