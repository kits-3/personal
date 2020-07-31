package project.management.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.management.config.ConnectionFatory;
import project.management.entity.UserEntity;
import project.management.repository.IUserRepository;

public class UserRepository implements IUserRepository {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFatory.getInstance().getConnection();
		return conn;
	}
	@Override
	public UserEntity findbyuserNameAndPassword(String user) {
		UserEntity cus = new UserEntity();
		
		try {
			String queryString = "SELECT u.id, fullname, username, password, code  FROM user u, role r, user_role ur WHERE u.id = ur.userid AND r.id = ur.roleid AND username =?";
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, user);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				
				
				cus.setId(rs.getInt("id"));
				cus.setFullname(rs.getString("fullname"));
				cus.setUsername(rs.getString("username"));
				cus.setPassword(rs.getString("password"));
				cus.setRole(rs.getString("code"));
			}
			
			return cus;
		}catch (SQLException e) {
			e.getStackTrace();
		}
		catch (Exception e) {
			e.getStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
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
		return cus;
	}
	
}
