package home.orderFood.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.orderFood.config.ConnectionFactory;
import home.orderFood.entity.UserEntity;




public class UserRepositorylmpl implements UserRepository {
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> lsUser = new ArrayList<UserEntity>();
		String queryString = "SELECT * FROM user";
		
		try {
				connection = getConnection();
				
				stmt = connection.prepareStatement(queryString);
				rs = stmt.executeQuery(); //Select
				
				while(rs.next()) {
					UserEntity ad = new UserEntity();					
					ad.setId(rs.getInt("id"));
					ad.setUserName(rs.getString("userName"));
					ad.setPassWordUser(rs.getString("passWorduser"));
					ad.setFullNameUser(rs.getString("fullNameUser"));
					ad.setPhoneUser(rs.getString("phoneUser"));
					ad.setEmailUser(rs.getString("emailUser"));
					lsUser.add(ad);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException e) {
				System.out.println(e);
			}
		}
		return lsUser;
	}

	 
	@Override
	public UserEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(UserEntity e) {
		// TODO Auto-generated method stub
		String queryString = "INSERT INTO  user(userName, passWordUser, emailuser, phoneUser, fullNameUser) " + "VALUES (?, ?, ?, ?, ?)";
		
		try {
			
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, e.getUserName());
			stmt.setString(2, e.getPassWordUser());
			stmt.setString(3, e.getEmailUser());
			stmt.setString(4, e.getPhoneUser());
			stmt.setString(5, e.getFullNameUser());
			stmt.executeUpdate();
			//insert
			System.out.println("Sign Up Success!!!! \n");
		} catch (SQLException m) {
			// TODO Auto-generated catch block
			m.printStackTrace();
		}
		finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			}
			catch (SQLException m) {
				System.out.println(m);
			}
		}
		 
	}
	
	
	public UserEntity get(UserEntity e) {
		String queryString = "SELECT * FROM user WHERE userName= ? AND passWordUser= ?";
		UserEntity ad = new UserEntity();
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, e.getUserName());
			stmt.setString(2, e.getPassWordUser());
			
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				ad.setUserName(rs.getString("userName"));
				ad.setPassWordUser(rs.getString("passWorduser"));
				 
			}
			
			return ad;

	} catch (SQLException n) {
		// TODO Auto-generated catch block
		n.printStackTrace();
		System.err.println("Your login failed!!!! \n");
	}
	finally {
		try {
			if (connection != null) {
				connection.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		catch (SQLException n) {
			System.out.println(n);
		}
	}
		return null;
	}
}
