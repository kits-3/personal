package home.computer.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
	private String driverDB = "org.mariadb.jdbc.Driver";
	private String connectionURL = "jdbc:mariadb://localhost:3306/computer";
	private String dbUser = "root";
	private String dbPass = "root123";
	
	private static connectionFactory instance = null;

	public connectionFactory() {
		try {
			Class.forName(driverDB);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static connectionFactory getInstance() {
		if (instance == null)
		{
			instance = new connectionFactory();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionURL,dbUser,dbPass);
		
		return conn;
	}
	
	
	
	
}
