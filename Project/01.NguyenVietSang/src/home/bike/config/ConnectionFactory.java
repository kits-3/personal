package home.bike.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String driverDb = "org.mariadb.jdbc.Driver";
	private	String connectionUrl = "jdbc:mariadb://localhost:3306/bike_db";
	private	String dbUser = "root";
	private	String dbPwd = "123456";
	 private static ConnectionFactory instance = null;
	 private ConnectionFactory() {
		 try {
			Class.forName(driverDb);
		} catch (Exception e) {
			e.printStackTrace();		 
	 }		 
}
	 public static ConnectionFactory getInstance() {
			if (instance == null) {
				instance = new ConnectionFactory();
			}
			return instance;
	 }
	 public Connection getConnection() throws SQLException {
			Connection conn = null;
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			return conn;
		}
}	