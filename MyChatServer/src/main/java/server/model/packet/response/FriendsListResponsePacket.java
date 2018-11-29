package server.model.packet.response;

import lombok.Data;
import server.model.Packet;
import server.model.user.UserEntity;

import java.util.List;

import static server.utils.command.FRIENDS_LIST_RESPONSE;
@Data
public class FriendsListResponsePacket extends Packet {
    private List<UserEntity> friendList;
    @Override
    public Byte getCommand() {
        return FRIENDS_LIST_RESPONSE;
    }
}
