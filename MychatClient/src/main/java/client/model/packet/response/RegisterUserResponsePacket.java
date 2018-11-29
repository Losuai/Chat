package client.model.packet.response;

import client.utils.common.Packet;
import lombok.Data;


import static client.utils.command.REGISTER_USER_RESPONSE;

@Data
public class RegisterUserResponsePacket extends Packet {
    private boolean success;
    private String reason;
    @Override
    public Byte getCommand() {
        return REGISTER_USER_RESPONSE;
    }
}
