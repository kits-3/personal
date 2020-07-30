package pj.tour.repository.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pj.tour.config.ConnectionFactory;
import pj.tour.entity.AccountEntity;
import pj.tour.entity.UserEntity;

public class AccountRepositoryImpl implements AccountRepository, CheckAccessRight, RegisterAccount, LoginAccount {

	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	static boolean login = true;

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	Scanner input = new Scanner(System.in);
	AccountEntity account = new AccountEntity();
	List<AccountEntity> listAccount = new ArrayList<AccountEntity>();

	@Override
	public void findAll() {
		// TODO Auto-generated method stub

		try {
			String quertString = "Select * from user_account";
			connection = getConnection();
			stmt = connection.prepareStatement(quertString);
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Username_ac : " + rs.getString("username_ac") + " Password_ac : "
						+ rs.getString("password_ac") + " nameaccount : " + rs.getString("nameaccount"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
			} catch (SQLException e) {
				System.out.println(e);
			}

		}
	}

	@Override
	public void addAccount(AccountEntity acc) {
		// TODO Auto-generated method stub
		List<AccountEntity> lsRegister = new ArrayList<AccountEntity>();
		try {
			String queryString = "INSERT INTO " + "user_account(username_ac, password_ac, nameaccount , access_right)"
					+ "VALUES(?,?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, acc.getUsername_ac());
			stmt.setString(2, acc.getPassword_ac());
			stmt.setString(3, acc.getNameaccount());
			stmt.setString(4, acc.getAccess_right());
			stmt.executeUpdate();
//			rs = stmt.getGeneratedKeys();
//			while (rs.next()) {
//				int idUser = rs.getInt("id");
//				return idUser;
//			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateAccount(AccountEntity acc) {
		// TODO Auto-generated method stub
		try {
			String queryString = "update user_account set username_ac = ? " + "access_right" + "date=? "
					+ "password_ac = ?" + " nameaccount = ?";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, acc.getUsername_ac());
			stmt.setString(2, acc.getPassword_ac());
			stmt.setString(3, acc.getNameaccount());
			stmt.setString(4, acc.getDate());
			stmt.setString(5, acc.getAccess_right());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int deleteAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AccountEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logInAccount(AccountEntity acc) {
		// TODO Auto-generated method stub
		System.out.println("Log in");
		try {
			do {
				System.out.println("UserName: ");
				String userNameLogin = input.next();
				System.out.println("PassWord: ");
				String passWordLogin = input.next();
				String quertString = "Select * from user_account where username_ac = ? and password_ac = ?";
				connection = getConnection();
				stmt = connection.prepareStatement(quertString);
				stmt.setString(1, userNameLogin);
				stmt.setString(2, passWordLogin);				
				rs = stmt.executeQuery();
				
				if (rs.next()) {
					if (userNameLogin.equals(rs.getString("username_ac"))
							&& passWordLogin.equals(rs.getString("password_ac"))) {
						System.out.println("login Success!! ");
						boolean check = checkAccess(userNameLogin);
						
						if (check) {
							System.out.println("Authority "+ rs.getString("access_right"));
						}else {
							System.out.println("Authority " + rs.getString("access_right"));
						}
					}
					login = false;
				} else {
					System.out.println("Username or Password not correct!! Please Try Again !! ");
				}
				
				
			}while(login);
			return rs.getString("access_right");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return null;
	}
	
	
	@Override
	public void registerAccount(AccountEntity account) {
		UserEntity user = new UserEntity();
		String userNamesigin = null;
		String passWordSignin = null;
		String nameAccountSignin = null;
		String accessRight = null;
		try {
			while (login) {
				System.out.print("username: "); 	
				userNamesigin = input.next();
				String quertString = "Select username_ac from user_account where username_ac = ?";
				connection = getConnection();
				stmt = connection.prepareStatement(quertString);
				stmt.setString(1, userNamesigin);
				rs = stmt.executeQuery();
				if (rs.next()) {  // column __ 
					System.out.println("username has!");
				} else {
					account.setUsername_ac(userNamesigin);
					login = false;
				}
			}
			
			System.out.print("passWord: ");
			passWordSignin = input.next();
			account.setPassword_ac(passWordSignin);

			System.out.print("NameAccount: ");
			nameAccountSignin = input.next();
			account.setNameaccount(nameAccountSignin);
			
			accessRight = "user";
			account.setAccess_right(accessRight);
			
			addAccount(account);
			System.out.println("Register Done!!");
						
//			int id = addAccount(account);
//			System.out.println("show: "+ id);
			
			addUserInfo(user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
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

	
	
	@Override
	public boolean checkAccess(String name) {
		// TODO Auto-generated method stub
	
		try {
			String quertString = "Select username_ac, access_right from user_account where username_ac = ?";
			connection = getConnection();
			stmt = connection.prepareStatement(quertString);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {  // column __ 
				if (rs.getString("access_right") == "admin") {
					return true;
				}else {
					return false;
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
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
		return false;
	}

	@Override
	public void addUserInfo(UserEntity user) {
		// TODO Auto-generated method stub
		String name = null;
		System.out.print("name: ");
		name = input.next();
		
		String gmail = null;
		System.out.print("gmail: ");
		gmail = input.next();
		
		String ex = null;
		System.out.print("Ex(famale/male): ");
		ex = input.next();
		
		String phonenumber = null;
		System.out.print("phonenumber: ");
		phonenumber = input.next();
		
		String address = null;
		System.out.print("address: ");
		address = input.next();
		
//		String id_ac = checkId(name);
//		System.out.println("show: "+ id_ac);
		
		try {
			String queryString = "INSERT INTO user(name, gmail, ex, birthday, phonenumber, address) VALUES(?,?,?,now(),?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, name);
			stmt.setString(2, gmail);
			stmt.setString(3, ex);
			stmt.setString(4, phonenumber);
			stmt.setString(5, address);
//			stmt.setInt(6, id_ac);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String checkId(String name) {
		// TODO Auto-generated method stub
		try {
			String quertString = "Select id from user_account where username_ac = ?";
			connection = getConnection();
			stmt = connection.prepareStatement(quertString);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {  // column __ 
				String returnid = rs.getString("id");
				System.out.println("show check: "+ returnid);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
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
		return null;
	}

	

}
