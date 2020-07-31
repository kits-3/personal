package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectionFactory.ConnectionFactory;
import entity.Category;
import entity.Customer;
import entity.Product;

public class CategoryImpl implements CategoryDao{
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public void findCategory(int id) {
		try {
			String queryString = "select * from product where cate_id = ? ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, id);
			
			resultSet = ptmt.executeQuery();
			 
			
//			System.out.println("No Name\t\t\tPrice\t\tDetail");
//			System.out.println("----------------------------------------------");
			while (resultSet.next()) {
				System.out.println(""+resultSet.getInt("id")+". "+resultSet.getString("name")+"\t\t"+resultSet.getInt("price"));
				
			}
//			System.out.println("----------------------------------------------");
			 
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
		 
	}

	
	

}
