package kits.learnvocab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kits.learnvocab.config.ConnectionFactory;
import kits.learnvocab.dto.LanguageDto;
import kits.learnvocab.dto.TopicDto;
import kits.learnvocab.dto.UserDto;

public class UserDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	static String username;
	static int id, role;
	public UserDao() {
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();	
		return conn;
	}
	
	public  List<UserDto> findAll() {
		List<UserDto> dtoList = new ArrayList<UserDto>();
		try {
			String queryString = "SELECT * FROM user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
		
			while (resultSet.next()) {
				UserDto lstp = new UserDto();
				lstp.setId((resultSet.getInt("id")));
				lstp.setUsername(resultSet.getString("username"));
				lstp.setPassword(resultSet.getString("password"));
				lstp.setRole(resultSet.getInt("role"));
				dtoList.add(lstp);
				
			}
			return dtoList;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		return dtoList;
	}


	public void add(UserDto dto){
	try {
			String queryString ="INSERT INTO user(id, username, password, role) VALUES (?,?,?,?)";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1,dto.getId());
			ptmt.setString(2,dto.getUsername());
			Scanner sc = new Scanner(System.in);
		
			ptmt.setString(3,dto.getPassword());
			
			ptmt.setInt(4, dto.getRole());
			
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(ptmt != null) {
					ptmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	
	}

	
	


}
