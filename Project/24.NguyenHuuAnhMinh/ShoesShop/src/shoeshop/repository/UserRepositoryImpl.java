package shoeshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shoeshop.config.ConnectionFactory;
import shoeshop.entity.UserEntity;

public class UserRepositoryImpl implements UserRepository {
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> lsCustomer = new ArrayList();
		String queryString = "SELECT * FROM user";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				UserEntity cus = new UserEntity();
				
				cus.setUserId(rs.getInt("UserID"));
				cus.setUserName(rs.getString("UserName"));
				cus.setUserLoginID(rs.getString("UserLoginID"));
				cus.setPhone(rs.getString("phone"));
				cus.setEmail_address(rs.getString("email_address"));
				cus.setPassword(rs.getString("password"));
				cus.setRole(rs.getString("role"));
				cus.setMoneyleft(rs.getInt("Moneyleft"));
				
				stmt.executeUpdate();
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
	public UserEntity findById(int id) {
		
		return null;
	}

	@Override
	public UserEntity login(String id, String pwd) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Id: ");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		id = sc.nextLine();
		System.out.print("password: ");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		pwd = sc.nextLine();
		boolean success = false;
		UserEntity user = new UserEntity();
		String queryString = "select * from user where UserLoginId=? and password=?";
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, id);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				user.setUserName(rs.getString("UserName"));
				user.setUserLoginID(rs.getString("UserLoginID"));
				user.setEmail_address(rs.getString("email_address"));
				user.setMoneyleft(rs.getInt("Moneyleft"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getString("role"));
				user.setPassword(rs.getString("password"));
			}
			connection.close();
		} catch (SQLException e) {
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
		return user;
	}

	@Override
	public void addUser(UserEntity ce) {
		try{
			String queryString="INSERT INTO"
					+ " user(UserID,UserName,UserLoginID,phone,email_address,password,Moneyleft,role)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,ce.getUserId());
			stmt.setString(2,ce.getUserName());
			stmt.setString(3,ce.getUserLoginID());
			stmt.setString(4,ce.getPhone());
			stmt.setString(5,ce.getEmail_address());
			stmt.setString(6,ce.getPassword());
			stmt.setInt(7, ce.getMoneyleft());
			stmt.setString(8, "user");
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
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
	public void updateMoney(UserEntity ce) {
		try{
			String queryString=" UPDATE user set Moneyleft=? WHERE UserLoginID=?";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,ce.getMoneyleft());
			stmt.setString(2,ce.getUserLoginID());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
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
	public void signUp(UserEntity user , List<UserEntity> list_user,UserRepository userRepo) {
		Scanner sc = new Scanner(System.in);
		System.out.println("--Sign up--");
		UserEntity newUser = new UserEntity();
		String newID =" ";
		boolean idCheck = false;
		boolean spaceCheck = newID.chars().anyMatch(Character::isWhitespace);
		while(spaceCheck==true){
			System.out.print("ID: ");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			newID = sc.nextLine();
			if(newID.chars().anyMatch(Character::isWhitespace) == true) {
				System.out.println("ID can't have space");
			}else {
				while(idCheck == false){
					for(int j=0 ; j < list_user.size();j++){
						String a = list_user.get(j).getUserLoginID();
						if(newID.equals(a)){
							System.out.println("ID already exist");
							System.out.print("ID: ");
							sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
							newID = sc.nextLine();
						}else {
							idCheck=true;
						}
					}
				}
				if(newID.chars().anyMatch(Character::isWhitespace) == true)
				{
					System.out.println("ID can't have space");
					spaceCheck=true;
				}else {
					spaceCheck=false;
				}
				
			}
		}
		System.out.println("ID can be used");
		newUser.setUserLoginID(newID);
		System.out.print("Email: ");
		newUser.setEmail_address(sc.next());
		System.out.print("Phone: ");
		newUser.setPhone(sc.next());
		String newPwd = "";
		String confirmNewPwd = "";
		
		boolean checkPwd = false;
		System.out.print("Password: ");
		newPwd = sc.next();
		System.out.print("confirm password: ");
		while(checkPwd==false){
			confirmNewPwd = sc.next();
			if (newPwd.equals(confirmNewPwd)) {
				checkPwd = true;
				break;
			}else{
				checkPwd = false;
				System.out.print("Please confirm again: ");
			}
		}
		System.out.println("Confirm success!");
		System.out.print("Input your money: ");
		newUser.setMoneyleft(sc.nextInt());
		newUser.setPassword(newPwd);
		System.out.println("Sign up success!!");
		userRepo.addUser(newUser);
	}

	@Override
	public void updateAll(UserEntity ce) {
		try{
			String queryString=" UPDATE user set UserID=?,UserName=?,UserLoginID=?,phone=?,email_address=?,password=?,Moneyleft=?,role=?";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,ce.getUserId());
			stmt.setString(2,ce.getUserName());
			stmt.setString(3,ce.getUserLoginID());
			stmt.setString(4,ce.getPhone());
			stmt.setString(5,ce.getEmail_address());
			stmt.setString(6,ce.getPassword());
			stmt.setInt(7, ce.getMoneyleft());
			stmt.setString(8, ce.getRole());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
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
	public void showUser(List<UserEntity> listEntity) {
		for(int i = 0 ; i < listEntity.size();i++){
			System.out.printf("%-10s","ID: "+listEntity.get(i).getUserId()+" ");
			System.out.printf("%-30s","User Login ID: "+listEntity.get(i).getUserLoginID()+" ");
			System.out.printf("%-20s","Phone: "+listEntity.get(i).getPhone()+" ");
			System.out.printf("%-25s","Email: "+listEntity.get(i).getEmail_address()+" ");
			System.out.printf("%-15s","Money: "+listEntity.get(i).getMoneyleft()+" ");
			System.out.printf("%-10s %n" ,"Role: "+listEntity.get(i).getRole()+" ");
		}
	}
}
