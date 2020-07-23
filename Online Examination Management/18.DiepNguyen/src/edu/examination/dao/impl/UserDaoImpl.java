package edu.examination.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.examination.config.ConnectionFactory;
import edu.examination.dao.UserDao;
import edu.examination.entity.UserEntity;

public class UserDaoImpl implements UserDao{

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public UserDaoImpl() {
		
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<UserEntity> getAllUsers() {
		
		return null;
	}

	@Override
	public UserEntity getUser(int userID) {
		
		return null;
	}
	

	@Override
	public void addUser(UserEntity newUser) {
		try {
		String queryString = "Insert into user(userEmailAddress, userPassword) "
							+ "values(?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, newUser.getUserEmailAddress());
			ptmt.setString(2, newUser.getUserPassword());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				if(ptmt != null){
					ptmt.close();
				}
				if(connection != null){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}		
	}

}
