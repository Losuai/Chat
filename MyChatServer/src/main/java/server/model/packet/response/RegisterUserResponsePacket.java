package server.model.packet.response;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.REGISTER_USER_RESPONSE;
@Data
public class RegisterUserResponsePacket extends Packet {
    private boolean success;
    private String reason;
    @Override
    public Byte getCommand() {
        return REGISTER_USER_RESPONSE;
    }
}
