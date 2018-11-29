package server.model.packet.request;


import lombok.Data;
import server.model.Packet;

import static server.utils.command.REGISTER_USER_REQUEST;

@Data
public class RegisterUserRequestPacket extends Packet {
    private String username;
    private String password;
    private String phone;
    private String sign;
    @Override
    public Byte getCommand() {
        return REGISTER_USER_REQUEST;
    }
}
