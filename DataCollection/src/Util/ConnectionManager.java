package Util;

import Constant.StringConstant;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    public static Connection getConnectionFromThreadLocal() {
        Connection conn = connectionHolder.get();
        try {
            if (conn == null || conn.isClosed()) {
                Connection con = ConnectionManager.getConnection();
                connectionHolder.set(con);
                System.out.println("[Thread]" + Thread.currentThread().getName());
                return con;
            }
            return conn;
        } catch (Exception e) {
            System.out.println("[ThreadLocal Get Connection Error]" + e.getMessage());
        }
        return null;
    }

    private static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(StringConstant.MYSQL_DRIVER);
            conn = DriverManager.getConnection(
                    StringConstant.MYSQL_URL,StringConstant.USER_NAME,StringConstant.USER_PASSWORD);
        } catch (Exception e) {
            System.out.println("[Get Connection Error]" + e.getMessage());
        }
        return conn;
    }
}
