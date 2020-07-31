package home.computer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.computer.config.connectionFactory;
import home.computer.entity.userEntity;

public class userRepositoryImpl implements userRepository{
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = connectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public boolean signInUser(String u, String p) {
		boolean check = false;
		
		try {
			
			List<userEntity> userList = new ArrayList<userEntity>();
			String queryString = "SELECT User, Password FROM user";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			result = statement.executeQuery();
			
			
			while (result.next())
			{
				userEntity user = new userEntity();
				user.setUser(result.getString("User"));
				user.setPassword(result.getString("Password"));
				userList.add(user);
			}
			
			for (int i = 0; i < userList.size();i++)
			{
				if (u.equals(userList.get(i).getUser()))
				{
					for (int j = 0; j < userList.size(); j++)
					{
						if (p.equals(userList.get(j).getPassword()))
						{
							System.out.println("Login Success.");
							check = true;
							return check;
						}
						
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	@Override
	public boolean signUpUser(String u, String p) {
		boolean check = true;
		try {
			String queryString = "INSERT INTO user(User,Password,Type) VALUES(?,?,?) ";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			
			statement.setString(1, u);
			statement.setString(2, p);
			statement.setString(3, "user");
			statement.executeUpdate();
			System.out.println("SignUp Success");
		} catch (SQLException e) {
			System.out.println("user already exists. ");
			check = false;
			return check;
		}
		
		
		finally {
			try {
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
}
