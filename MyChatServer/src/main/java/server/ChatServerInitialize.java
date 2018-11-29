package server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import server.handler.requestHandler.*;

public class ChatServerInitialize extends ChannelInitializer<NioSocketChannel> {
    @Override
    protected void initChannel(NioSocketChannel nioSocketChannel){
        nioSocketChannel.pipeline().addLast(PacketCodecHandler.INSTANCE);
        nioSocketChannel.pipeline().addLast(new LoginRequestHandler());
        nioSocketChannel.pipeline().addLast(new GroupMessageRequestHandler());
        nioSocketChannel.pipeline().addLast(new RegisterUserRequestHandler());
        nioSocketChannel.pipeline().addLast(new UpdateUserRequestHandler());
        nioSocketChannel.pipeline().addLast(new MessageRequestHandler());
    }
}
