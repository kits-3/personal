package khu13config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Khu13Config {
	private String driverDb="org.mariadb.jdbc.Driver";
	private String connectionUrl="jdbc:mariadb://localhost:3306/Khu13";
	private String dbUser="root";
	private String dbPass ="01639653319a";
	private static Khu13Config instance = null; // tao thuc the
	private Khu13Config() {
		try {
			Class.forName(driverDb); //khai bao Driver
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public Connection getConnection() throws SQLException{ //tao connection
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPass);
		return conn;
	}
	public static Khu13Config getInstance(){
		if(instance == null) {
			instance = new Khu13Config(); // khai bao thuc the
		}
		return instance;
		
	}
	
}
