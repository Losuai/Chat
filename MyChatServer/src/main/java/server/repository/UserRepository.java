package server.repository;

import server.model.packet.request.UpdateUserRequestPacket;
import server.model.user.UserEntity;
import server.utils.dbutils.JdbcTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public UserEntity findUserByName(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet st = null;
        String sql = "select * from user where username = ?";
        try {
            conn = JdbcTools.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            st= stmt.executeQuery();
            UserEntity user = new UserEntity();
            while (st.next()) {
                user.setId(st.getInt("id"));
                user.setPassword(st.getString("password"));
                user.setUsername(st.getString("username"));
                user.setTelephone(st.getString("telephone"));
                user.setSign(st.getString("sign"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcTools.closeResource(conn, stmt, st);
        }
        return null;
    }
    public List<UserEntity> findUserFriends(String userId){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet st = null;
        List<UserEntity> friendsList = new ArrayList<>();
        String sql = "SELECT * FROM user JOIN friend on user.id = friend.friendId WHERE friend.userId = ?";
        conn = JdbcTools.getConnection();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,Integer.parseInt(userId));
            st = stmt.executeQuery();
            while (st.next()){
                UserEntity friend = new UserEntity();
                friend.setId(st.getInt("id"));
                friend.setSign(st.getString("sign"));
                friend.setTelephone(st.getString("telephone"));
                friend.setUsername(st.getString("username"));
                friendsList.add(friend);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcTools.closeResource(conn, stmt, st);
        }
        return friendsList;
    }
    public List<UserEntity> findAllUser(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet st = null;
        List<UserEntity> userEntities = new ArrayList<>();
        String sql = "SELECT * FROM user ";
        conn = JdbcTools.getConnection();
        try {
            stmt = conn.prepareStatement(sql);
            st = stmt.executeQuery();
            while (st.next()){
                UserEntity user = new UserEntity();
                user.setId(st.getInt("id"));
                user.setSign(st.getString("sign"));
                user.setTelephone(st.getString("telephone"));
                user.setUsername(st.getString("username"));
                userEntities.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcTools.closeResource(conn, stmt, st);
        }
        return userEntities;
    }
    public void registerUser(UserEntity userEntity){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet st = null;
        String sql = "insert into user(username, password, telephone, sign ) values(?,?,?,?) ";
        try {
            conn = JdbcTools.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,userEntity.getUsername());
            stmt.setString(2,userEntity.getPassword());
            stmt.setString(3,userEntity.getTelephone());
            stmt.setString(4,userEntity.getSign());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcTools.closeResource(conn, stmt, st);
        }
    }
    public void updateUser(UpdateUserRequestPacket user){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet st = null;
        String sql = "update user set username = ?,password = ?, sign = ?, telephone = ? where username = ?";
        try {
            conn = JdbcTools.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,user.getUsername());
            stmt.setString(2,user.getNewPassword());
            stmt.setString(3,user.getSign());
            stmt.setString(4,user.getPhone());
            stmt.setString(5,user.getLastUsername());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcTools.closeResource(conn, stmt, st);
        }
    }
}
