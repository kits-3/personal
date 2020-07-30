package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQL {
	String driverClassName = "org.mariadb.jdbc.Driver";
	String connectionUrl = "jdbc:mariadb://localhost:3306/sellgame";
	String dbUser = "root";
	String dbPwd = "123123";
	
	private static ConnectSQL connectSql = null;
	
	private ConnectSQL() {
		try {
			Class.forName(driverClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {//ham ket noi
		Connection conn = null; //tao conn
		conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
		//khoi tao ket noi qua Drivermanager
		return conn;
	}
	public static ConnectSQL getInstance() {
		if(connectSql == null) {//kiem tra co chua
			connectSql = new ConnectSQL();
		}
		return connectSql;
	}
}
