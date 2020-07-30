package parkingSystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parkingSystem.config.ConnectionFactory;
import parkingSystem.entity.park;

public class parkRepositoryImpl implements parkRepository{
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<park> findAll() {
		List<park> lsPark = new ArrayList();
		String queryString = "SELECT * FROM park";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				park cus = new park();
				
				cus.setId(rs.getInt(1));
				cus.setName(rs.getString("name"));
				cus.setSize(rs.getString("size"));
				
				lsPark.add(cus);
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
		return lsPark;
	}

	@Override
	public park findById(int id) {
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
	public void add(park Park) {
		try {
			String queryString = "insert into park(name,size) values(?,?)";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1,Park.getName());
			stmt.setString(2,Park.getSize());
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

	
//	@Override 
//	public int getID(int ID_park)
//	{
//		try {
//			Connection con = getConnection();
//			PreparedStatement ps = con.prepareStatement("select id from park where id_user=?");
//			ps.setInt(1, );
//			ResultSet rs = ps.executeQuery();
//			if(rs.next())
//			{
//				int a = rs.getInt("id");
//				return a;
//			}
//			
//			
//		}
//		 catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			finally {
//				try {
//					if (connection != null) {
//						connection.close();
//					}
//					if (stmt != null) {
//						stmt.close();
//					}
//					if (rs != null) {
//						rs.close();
//					}
//				}
//				catch (SQLException e) {
//					System.out.println(e);
//				}
//			}
//		return 0;
//
//	}
}
