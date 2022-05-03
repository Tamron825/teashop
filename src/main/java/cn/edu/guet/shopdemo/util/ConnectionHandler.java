package cn.edu.guet.shopdemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();

    public static Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();//从ThreadLocal中取数据
        /*
        如果conn为null，说明当前线程对应的ThreadLocal中还没有我们要共享的Connection
         */
        if (conn == null) {
            String user = "root";
            String dbPassword = "Li123456";
            String url = "jdbc:mysql://120.25.165.180:3306/shop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            conn = DriverManager.getConnection(url, user, dbPassword);
            threadLocal.set(conn);
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = threadLocal.get();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.remove();
        }
    }
}
