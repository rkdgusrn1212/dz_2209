package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyClassDriver {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Properties pro;
			pro = new Properties();
			pro.load(new FileReader("C:\\Users\\Playdata\\Documents\\GitHub\\presentbook\\pb\\conn\\conn.properties"));
			Class.forName(pro.getProperty("driver"));
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
