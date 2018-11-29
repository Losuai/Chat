package client.utils.message;

import client.utils.common.Packet;
import client.utils.common.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object packet, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out, (Packet) packet);
}
}
