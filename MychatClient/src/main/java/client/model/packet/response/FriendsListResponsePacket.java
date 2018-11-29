package client.model.packet.response;

import client.model.User;
import client.utils.common.Packet;
import lombok.Data;
import java.util.List;
import static client.utils.command.FRIENDS_LIST_RESPONSE;

@Data
public class FriendsListResponsePacket extends Packet {
    private List<User> friendList;
    @Override
    public Byte getCommand() {
        return FRIENDS_LIST_RESPONSE;
    }
}
