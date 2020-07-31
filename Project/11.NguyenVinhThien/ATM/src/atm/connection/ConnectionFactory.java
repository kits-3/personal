package atm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String driverName = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://localhost:3306/db_atm";
	private String dbuser = "root";
	private String dbpass = "123456";
	
	private static ConnectionFactory instance = null;
	
	private ConnectionFactory() {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, dbuser, dbpass);
		return conn;
	}
	
}
