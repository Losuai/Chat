package client.model.packet.request;

import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private String userId;

    private String username;

    private String password;

    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
