package home.note.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	String driverClassName = "org.mariadb.jdbc.Driver";
	String ConnectionUrl = "jdbc:mariadb://localhost:3306/ghichudb";
	String dbUser = "root";
	String dbPwd = "123456";
	private static ConnectionFactory ConnectionFactory = null;
	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(ConnectionUrl, dbUser, dbPwd);
		return conn;
	}
	public static ConnectionFactory getInstance() {
		if (ConnectionFactory == null) {
			ConnectionFactory = new ConnectionFactory();
		}
		return ConnectionFactory;
	}
}
