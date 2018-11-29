package server.model.packet.response;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.LOGIN_RESPONSE;
@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;

    private String phone;

    private String sign;
    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
