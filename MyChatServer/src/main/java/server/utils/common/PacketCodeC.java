package server.utils.common;

import io.netty.buffer.ByteBuf;
import server.model.Packet;
import server.model.packet.request.*;
import server.model.packet.response.*;
import server.utils.Serializer;
import server.utils.message.JSONSerializer;

import java.util.HashMap;
import java.util.Map;

import static server.utils.command.*;

public class PacketCodeC {

    private static final int MAGIC_NUMBER = 0x12345678;
    private static final Map<Byte, Class<? extends Packet>> packetTypeMap;
    private static final Map<Byte, Serializer> serializerMap;
    public static final PacketCodeC INSTANCE = new PacketCodeC();

    static {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(MESSAGE_REQUEST,MessageRequestPacket.class);
        packetTypeMap.put(LOGIN_RESPONSE,LoginResponsePacket.class);
        packetTypeMap.put(MESSAGE_RESPONSE,MessageRequestPacket.class);
        packetTypeMap.put(GROUP_MESSAGE_REQUEST,GroupMessageRequestPacket.class);
        packetTypeMap.put(GROUP_MESSAGE_RESPONSE,GroupMessageResponsePacket.class);
        packetTypeMap.put(FRIENDS_LIST_RESPONSE,FriendsListResponsePacket.class);
        packetTypeMap.put(REGISTER_USER_REQUEST,RegisterUserRequestPacket.class);
        packetTypeMap.put(REGISTER_USER_RESPONSE, RegisterUserResponsePacket.class);
        packetTypeMap.put(UPDATE_USER_RESPONSE,UpdateUserResponsePacket.class);
        packetTypeMap.put(UPDATE_USER_REQUEST,UpdateUserRequestPacket.class);
        serializerMap = new HashMap<>();
        Serializer serializer = new JSONSerializer();
        serializerMap.put(serializer.getSerializerAlgorithm(), serializer);
    }


    public void encode(ByteBuf byteBuf, Packet packet) {
        // 1. 序列化 java 对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        // 2. 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }


    public Packet decode(ByteBuf byteBuf) {
        // 跳过 magic number
        byteBuf.skipBytes(4);

        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法
        byte serializeAlgorithm = byteBuf.readByte();

        // 指令
        byte command = byteBuf.readByte();

        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> requestType = getRequestType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (requestType != null && serializer != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

    private Serializer getSerializer(byte serializeAlgorithm) {

        return serializerMap.get(serializeAlgorithm);
    }

    private Class<? extends Packet> getRequestType(byte command) {

        return packetTypeMap.get(command);
    }
}
