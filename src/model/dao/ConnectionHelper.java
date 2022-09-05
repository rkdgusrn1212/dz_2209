package model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class ConnectionHelper {

    static Connection getConnection() {
        try {
            Properties pro = new Properties();
            pro.load(new FileReader("db.properties"));
            Class.forName(pro.getProperty("driver"));
            return DriverManager.getConnection(pro.getProperty("url"),pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static void close(Connection conn) {
        if(conn!=null) {//null pointer 방지, 예외 처리후에 호출되어지면 null이 넘어올 수 있다.
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    static void close(Statement stmt) {
        if(stmt!=null) {//null pointer 방지, 예외 처리후에 호출되어지면 null이 넘어올 수 있다.
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    static void close(ResultSet rs) {
        if(rs!=null) {//null pointer 방지, 예외 처리후에 호출되어지면 null이 넘어올 수 있다.
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
