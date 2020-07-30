package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdminEntity.Admin;
import AdminEntity.CategoryAdmin;
import ConnectionFactory.ConnectionFactory;

public class AdminImpl implements AdminDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	

	@Override
	public Admin login(String name, String pass) {
		Admin ad = new Admin();
		try {
			String queryString = "select * from admin where admin_name = ? AND password=? ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setString(1, name);
			ptmt.setString(2, pass);
			
			
			resultSet = ptmt.executeQuery();
			
			while (resultSet.next()) {
				ad.setName(resultSet.getString("admin_name"));
				ad.setPassword(resultSet.getString("password"));
			}
			return ad;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
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

}
