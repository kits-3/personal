package home.computer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import home.computer.config.connectionFactory;

public class categoryRepositoryImpl implements categoryRepository {
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = connectionFactory.getInstance().getConnection();
		
		return conn;
	}
	
	@Override
	public void insert_category() {
		try {
			System.out.print("Input Category:");
			String category = sc.next();
			String queryString = "INSERT INTO category (CategoryName) VALUES (?)";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setString(1, category);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
