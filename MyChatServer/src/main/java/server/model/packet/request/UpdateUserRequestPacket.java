package server.model.packet.request;

import lombok.Data;
import server.model.Packet;

import static server.utils.command.UPDATE_USER_REQUEST;


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
