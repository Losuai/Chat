package server.handler.requestHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import server.model.packet.request.UpdateUserRequestPacket;
import server.model.packet.response.UpdateUserResponsePacket;
import server.model.user.UserEntity;
import server.repository.UserRepository;

public class UpdateUserRequestHandler extends SimpleChannelInboundHandler<UpdateUserRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UpdateUserRequestPacket requestPacket) throws Exception {
        UserRepository userRepository = new UserRepository();
        UserEntity exitUser = userRepository.findUserByName(requestPacket.getLastUsername());
        UpdateUserResponsePacket updateUserResponsePacket = new UpdateUserResponsePacket();
        UpdateUserRequestPacket updateUserRequestPacket = new UpdateUserRequestPacket();
        if (exitUser != null){
            if (exitUser.getPassword().equals(requestPacket.getPassword())){
                updateUserResponsePacket.setSuccess(false);
                updateUserResponsePacket.setReason("原始密码错误");
                ctx.channel().writeAndFlush(updateUserResponsePacket);
                System.out.println("更新错误");
            }else{
                updateUserResponsePacket.setSuccess(true);
                updateUserRequestPacket.setLastUsername(requestPacket.getLastUsername());
                updateUserRequestPacket.setNewPassword(requestPacket.getNewPassword());
                updateUserRequestPacket.setPhone(requestPacket.getPhone());
                updateUserRequestPacket.setUsername(requestPacket.getUsername());
                updateUserRequestPacket.setSign(requestPacket.getSign());
                userRepository.updateUser(updateUserRequestPacket);
                updateUserResponsePacket.setReason("更新信息成功,请重新登录");
                ctx.channel().writeAndFlush(updateUserResponsePacket);
                System.out.println("更新成功");
            }
        }
    }
}
