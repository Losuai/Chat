package server.handler.requestHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import server.model.packet.request.RegisterUserRequestPacket;
import server.model.packet.response.RegisterUserResponsePacket;
import server.model.user.UserEntity;
import server.repository.UserRepository;

public class RegisterUserRequestHandler extends SimpleChannelInboundHandler<RegisterUserRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RegisterUserRequestPacket requestPacket) throws Exception {
        UserRepository userRepository = new UserRepository();
        UserEntity exitUser = userRepository.findUserByName(requestPacket.getUsername());
        RegisterUserResponsePacket registerUserResponsePacket = new RegisterUserResponsePacket();
        if(exitUser == null){
            registerUserResponsePacket.setSuccess(true);
            UserEntity user = new UserEntity();
            user.setUsername(requestPacket.getUsername());
            user.setPassword(requestPacket.getPassword());
            user.setTelephone(requestPacket.getPhone());
            user.setSign(requestPacket.getSign());
            userRepository.registerUser(user);
            registerUserResponsePacket.setReason("注册成功");
            ctx.channel().writeAndFlush(registerUserResponsePacket);
            System.out.println("注册成功");
        }else {
            registerUserResponsePacket.setSuccess(false);
            registerUserResponsePacket.setReason("该用户已存在");
            ctx.channel().writeAndFlush(registerUserResponsePacket);
            System.out.println("注册失败");
        }
    }
}
