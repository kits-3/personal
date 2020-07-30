package home.facebooks.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private String driverDb = "org.mariadb.jdbc.Driver";
	private String connectionUrl = "jdbc:mariadb://192.168.123.70:3306/spring-boot-hibernate";
	private String dbUser = "root";
	private String dbPass ="12345";
	
	private static ConnectionFactory instance = null;
	
	private ConnectionFactory() {
		try {
			Class.forName(driverDb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPass);
		return conn;
	}
}
