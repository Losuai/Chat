package client.model.packet.request;

import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.REGISTER_USER_REQUEST;
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
