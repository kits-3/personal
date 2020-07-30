package repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.ConnectSQL;
import entity.User;

public class UserRepositoryImpl implements UserRepository {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	public UserRepositoryImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectSQL.getInstance().getConnection();
		return conn;
	}

	@Override
	public void update(User us){
		//User us = new User();
		String sql = "update user set password=? where id=?";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1,us.getPassword());
			ptmt.setInt(2,us.getId());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	
				try {
					if( ptmt !=null) {
					ptmt.close();
					} 
					if( connection !=null ) {
						connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		
	}
	@Override
	public void delete(int id) {
		//User us = new User();
		String sql = "delete from user where id= ? ";
		
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			
			ptmt.setInt(1, id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if( ptmt !=null) {
					ptmt.close();
				} if(connection !=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	
	}
	@Override
	public void signIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		String user = sc.next();
		System.out.println("Password: ");
		String password = sc.next();
		try {
			if(true) {
				String driverClassName = "org.mariadb.jdbc.Driver";
				String connectionUrl = "jdbc:mariadb://localhost:3306/sellgame";
				 String dbUser = "root";
				 String dbPwd = "123123";
				 Connection  conn = null;
				 conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				String sql = "SELECT * FROM user WHERE username=? AND password = ?";
				PreparedStatement psm = conn.prepareStatement(sql);
				psm.setString(1, user);
				psm.setString(2, password);
				ResultSet rs = psm.executeQuery();
				if(rs.next()) {
					System.out.println("Login successful");
				}else {
					System.out.println("Login error");
					signIn();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Connected error");
		}
		
	}
	@Override
	public void signUp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Username: ");
		 String user = sc.next();
		System.out.println("Password: ");
		 String password = sc.next();
		 try {
			if(true) {
				String driverClassName = "org.mariadb.jdbc.Driver";
				String connectionUrl = "jdbc:mariadb://localhost:3306/sellgame";
				 String dbUser = "root";
				 String dbPwd = "123123";
				 Connection  conn = null;
				 conn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
				 String sql = "INSERT INTO "+" user(username,password) "+" VALUES(?,?) ";
				 PreparedStatement psm = conn.prepareStatement(sql);
				 psm.setString(1, user);
				 psm.setString(2, password);
				 ResultSet rs = psm.executeQuery();
				 if(rs.next()) {
					 System.out.println("sign up successful");
				 }else {
					 System.out.println("sign up successful");
					 
				 }
			}
		} catch (Exception e) {
			System.out.println("username has someone used. Please input new username");
			signUp();
		}
		
	}
	@Override
	public List<User> infoUser() {
		List<User> lsUser = new ArrayList();
		String sql = "SELECT * from user";
		try {
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				User us = new User();
				us.setId(rs.getInt("id"));
				us.setUsername(rs.getString("username"));
				us.setPassword(rs.getString("password"));
				lsUser.add(us);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
				if(ptmt!=null) {
					ptmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return lsUser;
	}



	
}
