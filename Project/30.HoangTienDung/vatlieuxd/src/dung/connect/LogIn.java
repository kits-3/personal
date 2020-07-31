package dung.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dung.dto.User;



public class LogIn {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public LogIn() {
	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	
	
	public boolean checkLogIn(User users) {
		boolean check = false;
		try {
			String queryString = "SELECT * FROM users where user=? AND password = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, users.getUser());
			ptmt.setString(2, users.getPassword());
			resultSet = ptmt.executeQuery();
			if(resultSet.next()) {
				check = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
			check = false;
			
		} 
		if(check == false) System.out.println("user or password false");
		return check;
	}
	
	
	
	public boolean checkDuplicate(String user) {
		boolean check = false;
		try {
			String queryString = "SELECT * FROM users where user=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);
			resultSet = ptmt.executeQuery();
			if(resultSet.next()) check = true;
		} catch (Exception e) {
			e.getStackTrace();
			check = false;
		} 
		return check;
	}
	
	public int checkPermission(User users) {
		int check=0;
		try {
			String queryString = "SELECT role_name FROM users where user=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, users.getUser());
			resultSet = ptmt.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getString("role_name").equalsIgnoreCase("admin")) check = 1;
				if(resultSet.getString("role_name").equalsIgnoreCase("client")) check = 2;
			}
		} catch (Exception e) {
			e.getStackTrace();
		} 
		return check;
	}
}
