package client;

import client.handler.response.*;
import client.utils.message.PacketDecoder;
import client.utils.message.PacketEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel){
        socketChannel.pipeline().addLast(new PacketDecoder());
        socketChannel.pipeline().addLast(new FriendsListResponseHandler());
        socketChannel.pipeline().addLast(new LoginResponseHandler());
        socketChannel.pipeline().addLast(new GroupMessageResponseHandler());
        socketChannel.pipeline().addLast(new MessageResponseHandler());
        socketChannel.pipeline().addLast(new RegisterUserResponseHanlder());
        socketChannel.pipeline().addLast(new UpdateUserResponseHandler());
        socketChannel.pipeline().addLast(new MessageResponseHandler());
        socketChannel.pipeline().addLast(new PacketEncoder());

    }
}