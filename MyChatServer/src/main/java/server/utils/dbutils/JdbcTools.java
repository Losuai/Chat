package server.utils.dbutils;

import java.sql.*;

public class JdbcTools {
    static{
        try {
            Class.forName(CommonValue.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CommonValue.JDBC_URL,CommonValue.JDBC_USER,CommonValue.JDBC_PWD);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败");
        }
        return conn;
    }
    public static void closeResource(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if(rs!= null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!= null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!= null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
