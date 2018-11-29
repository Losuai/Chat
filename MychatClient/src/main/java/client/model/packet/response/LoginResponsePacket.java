package client.model.packet.response;

import client.utils.common.Packet;
import lombok.Data;
import static client.utils.command.LOGIN_RESPONSE;


@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private String phone;
    private String sign;
    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
