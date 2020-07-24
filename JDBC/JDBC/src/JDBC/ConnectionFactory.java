package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String driverClassName = "org.mariadb.jdbc.Driver";
	String connectionUrl = "jdbc:mariadb://localhost:3306/test";
	String dbUser = "root";
	String dbPwd = "chucthien131";
	
	private static ConnectionFactory connectionFactory = null;
	
	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException {
		Connection conn =null;
		conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
		return conn;
	}
	
	public static ConnectionFactory getInstance() {
		if(connectionFactory ==null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
