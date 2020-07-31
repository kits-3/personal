package home.orderFood.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.orderFood.config.ConnectionFactory;
import home.orderFood.entity.AdminEntity;


public class AdminRepositorylmpl implements AdminRepository {
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<AdminEntity> findAll() {
		List<AdminEntity> lsAdmin = new ArrayList();
		String queryString = "SELECT * FROM admin";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				AdminEntity ad = new AdminEntity();
				ad.setId(rs.getInt(1));
				ad.setUserName(rs.getString("user:"));
				ad.setPassWordAdmin(rs.getString("PassWord:"));
				ad.setEmailAdmin(rs.getString("Email:"));
				ad.setPhoneAdmin(rs.getString("Phone:"));
				ad.setFullNameAdmin(rs.getString("FullName:"));
				lsAdmin.add(ad);
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
		return lsAdmin;
	}

	@Override
	public AdminEntity findById(int id) {
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
	public void add(String AdminName, String PassWordAdmin, String FullNameAdmin, String PhoneAdmin, String EmailAdmin) 
	{
	  String queryString = "INSERT INTO admin(adminName, passWordAdmin, fullNameAdmin, phoneAdmin, emailAdmin) " +"VALUES (?, ?, ?, ?, ?)";
	  try {
		  connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, AdminName);
			stmt.setString(2, PassWordAdmin);
			stmt.setString(3, FullNameAdmin);
			stmt.setString(4, PhoneAdmin);
			stmt.setString(5, EmailAdmin);
			rs = stmt.executeQuery(); //Select
			System.out.println("Dang ki thanh cong \n");
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  finally
	  {
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
			catch (SQLException e)
		  	{
				System.out.println(e);
			}
	  }
	}
}
