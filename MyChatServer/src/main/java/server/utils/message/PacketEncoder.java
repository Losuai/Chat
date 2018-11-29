package server.utils.message;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import server.model.Packet;
import server.utils.common.PacketCodeC;

public class PacketEncoder extends MessageToByteEncoder {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object packet, ByteBuf out) throws Exception {
        PacketCodeC.INSTANCE.encode(out, (Packet) packet);
    }
}
