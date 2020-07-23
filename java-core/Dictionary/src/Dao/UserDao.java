package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.ConnectionFactory;
import model.userDto;

public class UserDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public UserDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(userDto dto) {
		try {
			String queryString = "INSERT INTO " + "user(username,password,roleId)" + "VALUES(?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getUserName());
			ptmt.setString(2, dto.getPassWord());
			ptmt.setInt(3, dto.getRoleId());
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(userDto dto) {
		try {
			String queryString = "update user set username=? ," + "password=?," + "roleId=? where username = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getUserName());
			ptmt.setString(2, dto.getPassWord());
			ptmt.setInt(3, dto.getRoleId());
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String id) {
		try {
			String queryString = "delete from user where username =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, id);
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<userDto> findAll() {
		try {
			String queryString = "Select * from user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<userDto> dtoList = new ArrayList<userDto>();
			int i = 0;
			while (resultSet.next()) {
				userDto dto = new userDto();
				dto.setUserName(resultSet.getString("username"));
				dto.setPassWord(resultSet.getString("password"));
				dto.setRoleId(resultSet.getInt("roleId"));
				dtoList.add(dto);
//				System.out.println("User Name : " + resultSet.getString("username")
//				+ "Pass word : " 
//				+ resultSet.getString("password"));
			}

			return dtoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public userDto checkLogin(String userName, String password) {
		try {
			userDto dto = new userDto();
			String queryString = "Select * from user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
//			ptmt.setString(1, userName);
			resultSet = ptmt.executeQuery();
			boolean flag = false;
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(userName)) {
					flag = true;
					if (resultSet.getString("password").equals(password)) {
						System.out.println("Login success");
						dto.setUserName(resultSet.getString("username"));
						break;
					}
					
				}
	
			}
			if(dto.getUserName() == null && flag == false) {
				System.out.println("wrng username");
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void checkRole(Integer roleId) {
		if (roleId == 1) {
			System.out.println("Hello admin");
		} else {
			System.out.println("Hello client");
		}
	}
}
