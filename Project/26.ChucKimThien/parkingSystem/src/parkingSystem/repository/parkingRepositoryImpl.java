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
		List<parking> lsParking = new ArrayList();
		String queryString = "SELECT * FROM parking";
		
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
				
				lsParking.add(cus);
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
		return lsParking;
	}
	
	@Override
	public void add(parking Parking) {
		try {
			String queryString = "insert into parking(id_car,id_park,position,date_in,date_out,price) values(?,?,?,?,?,?)";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,Parking.getId_car());
			stmt.setInt(2,Parking.getId_park());
			stmt.setString(3,Parking.getPosition());
			stmt.setString(4,Parking.getDate_in());
			stmt.setString(5,Parking.getDate_out());
			stmt.setString(6,Parking.getPrice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
				{
					rs.close();
				}
				if(connection !=null)
				{
					connection.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
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
