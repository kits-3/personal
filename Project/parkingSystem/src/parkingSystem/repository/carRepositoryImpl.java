package parkingSystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parkingSystem.config.ConnectionFactory;
import parkingSystem.entity.car;

public class carRepositoryImpl implements carRepository{
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<car> findAll() {
		List<car> lsCar = new ArrayList();
		String queryString = "SELECT * FROM car";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				car cus = new car();
				
				cus.setId(rs.getInt(1));
				cus.setId_user(rs.getInt(1));
				cus.setBrand(rs.getString("brand"));
				cus.setColor(rs.getString("color"));
				
				lsCar.add(cus);
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
		return lsCar;
	}

	public void add(car Car) {
		try {
			String queryString = "INSERT INTO "+ "car(id_user,brand,color)"
					+ "VALUES(?,?,?)";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,Car.getId_user());
			stmt.setString(2,Car.getBrand());
			stmt.setString(3,Car.getColor());
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
	public car findById(int id) {
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
	public int getID(int id_user) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select id from car where id_user=?");
			ps.setInt(1, id_user);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				int a = rs.getInt("id");
				return a;
			}
			
			
		}
		 catch (SQLException e) {
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
		return 0;

	}
}

