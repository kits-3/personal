package home.orderFood.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.orderFood.config.ConnectionFactory;
import home.orderFood.entity.OrderEntity;


public class OrderRepositorylmpl implements OrderRepository {
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<OrderEntity> findAll() {
		List<OrderEntity> lsOrder = new ArrayList();
		String queryString = "SELECT * FROM order";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				OrderEntity ad = new OrderEntity();
				ad.setId(rs.getInt("id:"));
				ad.setCustomerName(rs.getString("Name:"));
				ad.setAddressCustomer(rs.getString("Adress:"));
				ad.setPhoneCustomer(rs.getString("Phone:"));
				ad.setCityCustomer(rs.getString("City:"));
				ad.setWarCustomer(rs.getString("War:"));
				
				
				lsOrder.add(ad);
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
		return lsOrder;
	}

	@Override
	public OrderEntity findById(int id) {
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

}
