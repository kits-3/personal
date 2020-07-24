package JDBC;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet=null;
	
	public dao() {
		
	}
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public void add(Dto dto) {
		try {
			String queryString = "INSERT INTO "+ "user(name,dprtmt_id,rank_id,reg_id,reg_date,updt_id,updt_date)"
					+ "VALUES(?,?,?,?,now(),?,now())";
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,dto.getName());
			ptmt.setString(2,dto.getDprtmt_id());
			ptmt.setString(3,dto.getRank_id());
			ptmt.setString(4,"1");
			ptmt.setString(5,"1");
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
				{
					resultSet.close();
				}
				if(ptmt!=null) {
					ptmt.close();
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
	public void update(Dto dto)
	{
		try {
			String queryString = "UPDATE user set name=?,dprtmt_id=?,rank_id=? WHERE id =?)";
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,dto.getName());
			ptmt.setString(2,dto.getDprtmt_id());
			ptmt.setString(3,dto.getRank_id());
			ptmt.setString(4,dto.getId());
			ptmt.setString(5,"1");
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
				{
					resultSet.close();
				}
				if(ptmt!=null) {
					ptmt.close();
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
	public void delete(String id) {
		try {
			String queryString = "DELETE FROM user WHERE id=?)";
			connection=getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1,id);
			ptmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
				{
					resultSet.close();
				}
				if(ptmt!=null) {
					ptmt.close();
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
	public List<Dto> findAll() {
		String queryString = "Select * from user";
		try {
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		resultSet = ptmt.executeQuery();
		List<Dto> dtoList = new ArrayList<>();
		int i=0;
		while(resultSet.next())
		{
			dtoList.get(i).setId(resultSet.getString("id"));
			dtoList.get(i).setName(resultSet.getString("name"));
			dtoList.get(i).setRank_id(resultSet.getString("rank_id"));
			System.out.println("id :"+resultSet.getString("id")+"name: "+resultSet.getString("name"));
		}
		return dtoList;
		} catch (SQLException e) {
			// TODO: handle exception 
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet!=null)
				{
					resultSet.close();
				}
				if(ptmt!=null) {
					ptmt.close();
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
		return null;
		
	}
}
