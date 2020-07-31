package shoeshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoeshop.config.ConnectionFactory;
import shoeshop.entity.ProductEntity;
import shoeshop.entity.UserEntity;
import shoeshop.entity.orderItemEntity;

public class OrderItemRepositoryImpl implements OrderItemRepository{

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public void addOderItem(ProductEntity proE , orderItemEntity oE , UserEntity user) {
		try{
			String queryString="INSERT INTO"
					+ " orderitem(OrderItemID,CustomerLoginID,ProductID,ProductName,Quantity)"
					+ "VALUES(?,?,?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1, oE.getOrderItemID());
			stmt.setString(2,user.getUserLoginID());
			stmt.setInt(3, proE.getProductID());
			stmt.setString(4, proE.getProductName());
			stmt.setInt(5, oE.getQuantity());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public int getMaxID(orderItemEntity oE) {
		try{
			String queryString="SELECT MAX(OrderItemID) FROM orderitem";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<orderItemEntity> findOrderItem() {
		List<orderItemEntity> lsOrderItem = new ArrayList<>();
		String queryString = "SELECT * FROM orderitem";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				orderItemEntity orItem = new orderItemEntity();
				
				orItem.setOrderItemID(rs.getInt("OrderItemID"));
				orItem.setCustomerLoginID(rs.getString("CustomerLoginID"));
				orItem.setProductName(rs.getString("ProductName"));
				orItem.setQuantity(rs.getInt("Quantity"));
				lsOrderItem.add(orItem);
			}
	
		} catch (SQLException e) {
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
		return lsOrderItem;
	}

	@Override
	public void showOrderItem(List<orderItemEntity> lsOrder) {
		System.out.printf("%-5s","ID");
		System.out.printf("%-30s","Customer login name");
		System.out.printf("%-30s","Product name");
		System.out.printf("%-3s %n","Quantity");
		for(int i = 0 ; i < lsOrder.size();i++){
			System.out.printf("%-5s",lsOrder.get(i).getOrderItemID());
			System.out.printf("%-30s",lsOrder.get(i).getCustomerLoginID());
			System.out.printf("%-30s",lsOrder.get(i).getProductName());
			System.out.printf("%-3s %n",lsOrder.get(i).getQuantity());
		}
	}
}
