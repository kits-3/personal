package dao;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectiondb.ConnectionFactory;
import dto.Student;
import dto.User;
import implement.studentImpl;

public class StudentDao implements studentImpl {
	Connection connection = null;
	PreparedStatement ptmt = null;

	public StudentDao() {

	}

	private static Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstrance().getConnection();
		return conn;
	}
	@Override
	public int save(Student s) {
		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into studentacc(name,email,contactno,address,course,fee,paid,due) values(?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getContactno());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getCourse());
			ps.setInt(6, s.getFee());
			ps.setInt(7, s.getPaid());
			ps.setInt(8, s.getDue());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	@Override
	public int update(Student s) {
		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"update studentacc set name=?, email=?,contactno=?,address=? where rollno=?");
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getContactno());
			ps.setString(4, s.getAddress());
			ps.setInt(5, s.getRollno());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	@Override
	public List<Student> view() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentacc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setContactno(rs.getString("contactno"));
				s.setAddress(rs.getString("address"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setPaid(rs.getInt("paid"));
				s.setDue(rs.getInt("due"));
				list.add(s);
				s.display();
				System.out.println("----------------------------------------------------------------------------------------------------------------");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	@Override
	public void outPut() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		try {
			FileWriter myWriter = new FileWriter("teststudent.txt");
			
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentacc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setRollno(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setContactno(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setCourse(rs.getString(6));
				s.setFee(rs.getInt(7));
				s.setPaid(rs.getInt(8));
				s.setDue(rs.getInt(9));
				list.add(s);   
			}
			for(int i=0; i<list.size(); i++) {
				myWriter.write("\r\nRollno:"+list.get(i).getRollno()+" Name:"+list.get(i).getName()+" Email:"+list.get(i).getEmail()+" Contactno:"+list.get(i).getContactno()+" Address:"+list.get(i).getAddress()+" Course:"+list.get(i).getCourse()+" Fee:"+list.get(i).getFee()+" Paid:"+list.get(i).getPaid()+" Due:"+list.get(i).getDue()+"\r\n");
				}
			myWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public Student getStudentByRollno(int rollno) {
		Student s = new Student();
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentacc where rollno=?");
			ps.setInt(1, rollno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setContactno(rs.getString("contactno"));
				s.setAddress(rs.getString("address"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setPaid(rs.getInt("paid"));
				s.setDue(rs.getInt("due"));
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
	public Student getStudentByName(String name) {
		Student s = new Student();
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentacc where name=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setContactno(rs.getString("contactno"));
				s.setAddress(rs.getString("address"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setPaid(rs.getInt("paid"));
				s.setDue(rs.getInt("due"));
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
	public void delete(int rollno) {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from studentacc where rollno=?");
			ps.setInt(1, rollno);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Student> due() {
		List<Student> list = new ArrayList<Student>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from studentacc where due>0");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setContactno(rs.getString("contactno"));
				s.setAddress(rs.getString("address"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setPaid(rs.getInt("paid"));
				s.setDue(rs.getInt("due"));
				list.add(s);
				s.display();
				System.out.println("----------------------------------------------------------------------------------------------------------------");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
