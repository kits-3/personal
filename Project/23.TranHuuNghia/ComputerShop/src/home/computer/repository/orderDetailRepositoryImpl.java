package home.computer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.computer.config.connectionFactory;
import home.computer.entity.orderDetailEntity;

public class orderDetailRepositoryImpl implements orderDetailRepository {
	
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = connectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public void printRevenue() {
		List<orderDetailEntity> orderDetailLs = new ArrayList<orderDetailEntity>();
		
		try {
			String quereyString = "SELECT * FROM order_detail";
			connection = getConnection();
			statement = connection.prepareStatement(quereyString);
			result = statement.executeQuery();
			
			while (result.next()){
				orderDetailEntity orderDetail = new orderDetailEntity();
				orderDetail.setId(result.getInt("id"));
				orderDetail.setIdOrder(result.getInt("id_order"));
				orderDetail.setId_productName(result.getString("id_ProductName"));
				orderDetail.setQuantity(result.getInt("Quantity"));
				orderDetailLs.add(orderDetail);
			}
			int revenue = 0;
			for (int i = 0; i < orderDetailLs.size();i++)
			{
				
				System.out.printf("%-3s",orderDetailLs.get(i).getId());
				System.out.print(". | order: ");
				System.out.printf("%-3s",orderDetailLs.get(i).getIdOrder());
				System.out.print(" | product: ");
				System.out.printf("%-60s",orderDetailLs.get(i).getId_productName());
				System.out.printf("%-3s"," | Quantity: ");
				System.out.println(orderDetailLs.get(i).getQuantity());
				revenue = 0;
			}
			System.out.println("total revenue: " + revenue);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void insertOrderDetail(int idorder, String idproductname) {
		try {
			String queryString = "INSERT INTO computer.`order_detail`(id_order,id_ProductName,Quantity) VALUES(?,?,?) ";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setInt(1, idorder);
			statement.setString(2, idproductname);
			statement.setInt(3, 1);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
