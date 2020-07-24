package parkingSystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parkingSystem.config.ConnectionFactory;
import parkingSystem.entity.parking;

public class parkingRepositoryImpl implements parkingRepository{
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<parking> findAll() {
		List<parking> lsCustomer = new ArrayList();
		String queryString = "SELECT * FROM customer";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				parking cus = new parking();
				
				cus.setId(rs.getInt(1));
				cus.setId_car(rs.getInt(1));
				cus.setId_park(rs.getInt(1));
				cus.setPosition(rs.getString("position"));
				cus.setPrice(rs.getString("price"));
				cus.setDate_in(rs.getString("date in"));
				cus.setDate_out(rs.getString("date out"));
				
				lsCustomer.add(cus);
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
		return lsCustomer;
	}

	@Override
	public parking findById(int id) {
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
