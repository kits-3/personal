package pj.tour.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String driverDb = "org.mariadb.jdbc.Driver";
	String connectionURL = "jdbc:mariadb://localhost:3306/mysql_tour";
	String dbUser = "root";
	String dbPwd = "123456";
	
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
		conn = DriverManager.getConnection(connectionURL, dbUser, dbPwd);
		return conn;
	}
}
