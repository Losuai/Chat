package server.handler.requestHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import server.model.packet.request.LoginRequestPacket;
import server.model.packet.response.FriendsListResponsePacket;
import server.model.packet.response.LoginResponsePacket;
import server.model.session.Session;
import server.model.user.UserEntity;
import server.repository.UserRepository;
import server.utils.common.SessionUtil;

import java.util.List;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    public LoginRequestHandler() {
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket requestPacket) throws Exception {
        UserRepository userRepository = new UserRepository();
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        FriendsListResponsePacket friendsListResponsePacket = new FriendsListResponsePacket();
        UserEntity user = userRepository.findUserByName(requestPacket.getUsername());
        if (user == null){
            System.out.println("登录失败！！");
            loginResponsePacket.setSuccess(false);
            loginResponsePacket.setReason("不存在该用户");
            ctx.channel().writeAndFlush(loginResponsePacket);
        }else{
             if(user.getPassword().equals(requestPacket.getPassword())){
                 loginResponsePacket.setSuccess(true);
                 System.out.println(user.getUsername() + "登录成功！！");
                 Integer userId = user.getId();
                 loginResponsePacket.setUserId(userId.toString());
                 loginResponsePacket.setUserName(user.getUsername());
                 loginResponsePacket.setPhone(user.getTelephone());
                 loginResponsePacket.setSign(user.getSign());
                 List<UserEntity> friendList = userRepository.findUserFriends(userId.toString());
                 friendsListResponsePacket.setFriendList(friendList);
                 SessionUtil.bindSession(new Session(userId.toString(), requestPacket.getUsername()), ctx.channel());
                 SessionUtil.getChannel(userId.toString());
                 ctx.channel().writeAndFlush(loginResponsePacket);
                 System.out.println("返回数据！！");
                 ctx.channel().writeAndFlush(friendsListResponsePacket);
             }else {
                 System.out.println("登录失败！！");
                 loginResponsePacket.setSuccess(false);
                 loginResponsePacket.setReason("密码错误");
                 ctx.channel().writeAndFlush(loginResponsePacket);
             }


        }
    }
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
