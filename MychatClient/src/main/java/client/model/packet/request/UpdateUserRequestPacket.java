package client.model.packet.request;

import client.utils.common.Packet;
import lombok.Data;

import static client.utils.command.UPDATE_USER_REQUEST;

@Data
public class UpdateUserRequestPacket extends Packet {
    private String username;
    private String password;
    private String phone;
    private String sign;
    private String newPassword;
    private String lastUsername;
    @Override
    public Byte getCommand() {
        return UPDATE_USER_REQUEST;
    }
}
