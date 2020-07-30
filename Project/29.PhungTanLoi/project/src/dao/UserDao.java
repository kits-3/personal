package dao;

import java.util.ArrayList;
import java.util.List;

import connectiondb.ConnectionFactory;
import dto.Student;
import dto.User;
import implement.studentImpl;
import implement.userImpl;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements userImpl {
	Connection connection = null;
	PreparedStatement ptmt = null;

	public UserDao() {
	
	}

	private static Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstrance().getConnection();
		return conn;
	}
	@Override
	public boolean validate(String name, String password) {
		boolean status = false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}

		return status;
	}
	public static boolean checkLoop(String name) {
		boolean status = false;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				status = true;
			}
			con.close();
		} catch (Exception e) {
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
			PreparedStatement ps = con.prepareStatement("select roll_name from users where name=?");
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
				String aString =rs.getString("roll_name");
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
	public int add(User a) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into users(name,password,email,contactno,roll_name) values(?,?,?,?,'user')");
			ps.setString(1, a.getName());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getContactno());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public int updateRoll(User s) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update users set roll_name=? where id=?");
			ps.setString(1, s.getRoll_name());
			ps.setInt(2, s.getId());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	@Override
	public void delete(int id) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from users where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<User> view() {
		List<User> list = new ArrayList<>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setContactno(rs.getString(5));
				a.setRoll_name(rs.getString(6));
				list.add(a);
				a.display();
				System.out.println("----------------------------------------------------------------------------------------------------------------");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void outPut() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		try {
			FileWriter myWriter = new FileWriter("testuser.txt");
			
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User a = new User();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setContactno(rs.getString(5));
				a.setRoll_name(rs.getString(6));
				list.add(a);   
			}
			for(int i=0; i<list.size(); i++) {
				myWriter.write("\r\nName:"+list.get(i).getName()+" Password:"+list.get(i).getPassword()+" Email:"+list.get(i).getEmail()+" Contactno:"+list.get(i).getContactno()+" Rollname:"+list.get(i).getRoll_name()+"\r\n");
				}
			myWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public User getUserByName(String name) {
		User s = new User();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from users where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPassword(rs.getString("password"));
				s.setEmail(rs.getString("email"));
				s.setContactno(rs.getString("contactno"));
				s.setRoll_name(rs.getString("roll_name"));
				s.display();
				System.out.println("----------------------------------------------------------------------------------------------------------------");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}
	@Override
	public int update(User s) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update users set password=?, email=?,contactno=? where name=?");
			
			ps.setString(1, s.getPassword());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getContactno());
			ps.setString(4, s.getName());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
