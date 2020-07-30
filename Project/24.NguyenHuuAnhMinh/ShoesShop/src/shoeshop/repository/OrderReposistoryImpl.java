package shoeshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import shoeshop.config.ConnectionFactory;
import shoeshop.entity.UserEntity;
import shoeshop.entity.orderEntity;
import shoeshop.entity.orderItemEntity;

public class OrderReposistoryImpl  implements OrderRepository{

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public void addOrder(List<orderItemEntity> oE, UserEntity user, orderEntity orderE) {
		try{
			String queryString="INSERT INTO"
					+ " mainorder(UserLoginID,OrderItemID,TotalPrice)"
					+ " VALUES(?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			for(int i = 0 ; i < oE.size();i++) {
				stmt.setString(1, user.getUserLoginID());
				stmt.setInt(2, oE.get(i).getOrderItemID());
				stmt.setInt(3,orderE.getTotalPrice());
			}
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
	public int getTotal(orderEntity orderE) {
		try{
			String queryString="SELECT SUM(TotalPrice) FROM mainorder ";
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

}
