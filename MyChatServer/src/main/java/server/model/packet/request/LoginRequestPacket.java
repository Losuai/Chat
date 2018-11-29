package server.model.packet.request;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.LOGIN_REQUEST;
@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
