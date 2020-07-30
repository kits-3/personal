package parkingSystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import parkingSystem.config.ConnectionFactory;
import parkingSystem.entity.user;

public class userRepositoryImpl implements userRepository{
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<user> findAll() {
		List<user> lsUser = new ArrayList();
		String queryString = "SELECT id_user,fname, lname, phone, brand,color,position,date_in,date_out,price FROM user a,car b,parking c WHERE (a.id=b.id_user AND b.id=c.id_car)";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery();
			System.out.println("View mode:");
			
			while(rs.next())
			{
//					user u = new user();
//					u.setId(rs.getInt("id"));
//					lsUser.add(u);		
				System.out.println("\nid:"+rs.getInt("id_user")+" || first name:"+rs.getString("fname")
				+" || last name:"+rs.getString("lname")+" || phone:"+rs.getString("phone")+" || brand:"+rs.getString("brand")+" || color:"
				+rs.getString("color")+" || position:"+rs.getString("position")+" || date in:"+rs.getString("date_in")+" || date_out:"+rs.getString("date_out")
				+" || "+rs.getString("price"));
			}
			return lsUser;
			
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
		return lsUser;
	}


	@Override
	public void update(user User) {
		try {
			String queryString = "UPDATE user set fname=?,lname=?,phone=?,username=?,pass=?,role=? WHERE id =?";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1,User.getFname());
			stmt.setString(2,User.getLname());
			stmt.setString(3,User.getPhone());
			stmt.setString(4,User.getUsername());
			stmt.setString(5,User.getPass());
			stmt.setString(6,User.getRole());
			stmt.setInt(7,User.getId());
			stmt.executeUpdate();
			System.out.println("Update successful!");
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
				if(rs!=null)
				{
					rs.close();
				}
				if(rs!=null) {
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
	public void add(user User) {
		try {
			String queryString = "INSERT INTO "+ "user(fname,lname,phone,username,pass,role)"
					+ "VALUES(?,?,?,?,?,?)";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1,User.getFname());
			stmt.setString(2,User.getLname());
			stmt.setString(3,User.getPhone());
			stmt.setString(4,User.getUsername());
			stmt.setString(5,User.getPass());
			stmt.setString(6,User.getRole());
			stmt.executeUpdate();
			System.out.println("Add successfull!");
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
	public void creatAccount(user User) {
		try {
			String queryString = "INSERT INTO "+ "user(fname,lname,phone,username,pass,role)"
					+ "VALUES(?,?,?,?,?,?)";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1,User.getFname());
			stmt.setString(2,User.getLname());
			stmt.setString(3,User.getPhone());
			stmt.setString(4,User.getUsername());
			stmt.setString(5,User.getPass());
			stmt.setString(6,User.getRole());
			stmt.executeUpdate();
			System.out.println("Create account successful!");
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
	public void delete(int id) {
		try {
			String queryString = "DELETE FROM user WHERE id=?";
			connection=getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,id);
			stmt.executeUpdate();
			System.out.println("Delete successful!");
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
	public void findById(int a)
	{
		try {
			
			String queryString = "SELECT id_user,fname, lname, phone, brand,color,position,date_in,date_out,price FROM user a,car b,parking c WHERE (a.id=b.id_user AND b.id=c.id_car AND a.id=?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,a);
			rs = stmt.executeQuery();
			System.out.println("find successful!");
			List<user> userList = new ArrayList();
			if(rs.next())
			{
				System.out.println("\nid:"+rs.getInt("id_user")+" || first name:"+rs.getString("fname")
				+" || last name:"+rs.getString("lname")+" || phone:"+rs.getString("phone")+" || brand:"+rs.getString("brand")+" || color:"
				+rs.getString("color")+" || position:"+rs.getString("position")+" || date in:"+rs.getString("date_in")+" || date_out:"+rs.getString("date_out")
				+" || "+rs.getString("price"));
			}	
			
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
	public boolean validate(String name,String pass) {
		boolean status =false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where username=? and pass=?");
			ps.setString(1,name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				status = true;
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status = false;
		}
		return status;
	}
	
	@Override
	public boolean roll(String name) {
		boolean status = false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select role from user where username=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
				String aString =rs.getString("role");
				if (aString.equals("admin")) {
					status = true;
				}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	@Override
	public boolean checkLoop(String username) {
		boolean status = false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select *from user where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				status = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
	
	@Override
	public int getID(String username)
	{
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select id from user where username=?");
			ps.setString(1, username);
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
	@Override
	public void findByIdAdmin(int a)
	{
		try {
			
			String queryString = "SELECT id_user,fname, lname, phone,username,pass,role, brand,color,position,date_in,date_out,price FROM user a,car b,parking c WHERE (a.id=b.id_user AND b.id=c.id_car AND a.id=?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,a);
			rs = stmt.executeQuery();
			System.out.println("find successful!");
			List<user> userList = new ArrayList();
			if(rs.next())
			{
				System.out.println("\nid:"+rs.getInt("id_user")+" || first name:"+rs.getString("fname")
				+" || last name:"+rs.getString("lname")+" || phone:"+rs.getString("phone")+" || username:"+rs.getString("username")+" || pass:"+rs.getString("pass")
				+" || role:"+rs.getString("role")+" || brand:"+rs.getString("brand")+" || color:"+rs.getString("color")+
				" || position:"+rs.getString("position")+" || date in:"+rs.getString("date_in")+" || date_out:"+rs.getString("date_out")
				+" || "+rs.getString("price"));
			}	
			
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
	public void findAllAdmin()
	{
		String queryString = "SELECT id_user,fname, lname, phone,username,pass,role, brand,color,position,date_in,date_out,price FROM user a,car b,parking c WHERE (a.id=b.id_user AND b.id=c.id_car)";
		
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery();
			System.out.println("View mode:");
			
			while(rs.next())
			{
//					user u = new user();
//					u.setId(rs.getInt("id"));
//					lsUser.add(u);		
				System.out.println("\nid:"+rs.getInt("id_user")+" || first name:"+rs.getString("fname")
				+" || last name:"+rs.getString("lname")+" || phone:"+rs.getString("phone")+" || username:"+rs.getString("username")+" || pass:"+rs.getString("pass")
				+" || role:"+rs.getString("role")+" || brand:"+rs.getString("brand")+" || color:"+rs.getString("color")+
				" || position:"+rs.getString("position")+" || date in:"+rs.getString("date_in")+" || date_out:"+rs.getString("date_out")
				+" || "+rs.getString("price"));
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
	}
	

}
