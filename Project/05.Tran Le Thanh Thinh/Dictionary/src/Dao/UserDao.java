package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.Fidelity;

import Connection.ConnectionFactory;
import Entity.userDto;

public class UserDao {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public UserDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public void add(userDto dto) {
		try {
			String queryString = "INSERT INTO " + "user(username,password,roleId,email)" + "VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getUserName());
			ptmt.setString(2, dto.getPassWord());
			ptmt.setInt(3, dto.getRoleId());
			ptmt.setString(4, dto.getEmail());
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
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

	public void update(userDto dto) {
		try {
			String queryString = "update user set password=?," + "roleId=?," + "email=? where username = ?";

			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getPassWord());
			ptmt.setInt(2, dto.getRoleId());
			ptmt.setString(3, dto.getEmail());
			ptmt.setString(4, dto.getUserName());
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
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

	public void delete(String id) {
		try {
			String queryString = "delete from user where username =?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, id);
			ptmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
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

	public List<userDto> findAll() {
		try {
			String queryString = "Select * from user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<userDto> dtoList = new ArrayList<userDto>();
			int i = 0;
			while (resultSet.next()) {
				userDto dto = new userDto();
				dto.setUserName(resultSet.getString("username"));
				dto.setPassWord(resultSet.getString("password"));
				dto.setEmail(resultSet.getString("email"));
				dto.setRoleId(resultSet.getInt("roleId"));
				dtoList.add(dto);
//				System.out.println("User Name : " + resultSet.getString("username")
//				+ "Pass word : " 
//				+ resultSet.getString("password"));
			}

			return dtoList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
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
		return null;
	}

	public userDto checkLogin(String userName, String password) {
		try {
			userDto dto = new userDto();
			String queryString = "Select * from user";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
//			ptmt.setString(1, userName);
			resultSet = ptmt.executeQuery();
			boolean flag = false;
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(userName)) {
					flag = true;
					if (resultSet.getString("password").equals(password)) {
						System.out.println("Login success");
						dto.setUserName(resultSet.getString("username"));
						dto.setPassWord(resultSet.getString("password"));
						dto.setRoleId(resultSet.getInt("roleId"));
						dto.setEmail(resultSet.getString("email"));
						break;
					}
					System.out.println("wrong password");

				}

			}
			if (dto.getUserName() == null && flag == false) {
				System.out.println("wrong username");
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
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
		return null;
	}

	public void checkRole(Integer roleId, String username) {
		if (roleId == 1) {
			System.out.println("Hello" + " " + username + " admin ");
			showAdminArea();
		} else {
			System.out.println("Hello" + " " + username);
			showClientArea();
		}
	}

	public void showAdminArea() {
		Scanner scan = new Scanner(System.in);
		String choose = null;
		boolean exit = false;
		boolean back = false;

		while (true) {
			showOptionAdmin();
			choose = scan.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose Add new user");
				addNewUser();
				showConfirm();
			case "2":
				System.out.println("choose Find user");
				findUser();
				showConfirm();
				break;
			case "3":
				System.out.println("Update user");
				editAdmin();
				showConfirm();
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				back = true;
				break;

			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit && back) {
				break;
			}
		}
		return;
	}

	public void showClientArea() {
		Scanner scan = new Scanner(System.in);
		String choose = null;
		boolean exit = false;
		boolean back_admin = false;
		System.out.println("Well come back cliemt area");
		System.out.println("Dictionary System Demo Version 0.001");
		System.out.println(" ----------------------------------");
		System.out.println("1. Add new word");
		System.out.println("2. Find word");
		System.out.println("3. Edit word");
		System.out.println("4. Delete word");
		System.out.println("0. Exits");
		System.out.println(" ----------------------------------");
		System.out.print("Please choose: ");

		while (true) {
			choose = scan.nextLine();
			switch (choose) {
			case "1":
				System.out.println("choose Add new word");

				break;
			case "2":
				System.out.println("choose Find word");
				break;
			case "3":
				System.out.println("choose Edit word");
				break;
			case "4":
				System.out.println("choose Delete Edit word");
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				back_admin = true;
				break;

			default:
				System.out.println("invalid! please choose action in below menu:");
				break;
			}
			if (exit & back_admin) {
				break;
			}
		}
	}

	public void addNewUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please fill new username below");
		String username = scan.nextLine();
		System.out.println("Please fill new password below");
		String password = scan.nextLine();
		System.out.println("Please fill new email below");
		String email = scan.nextLine();
		Integer roleId = 2;
		userDto dto = new userDto();
		dto.setUserName(username);
		dto.setPassWord(password);
		dto.setRoleId(roleId);
		dto.setEmail(email);
		add(dto);
		System.out.println("Add new user success!");

	}

	public void addNewUser(String username) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please fill  password below");
		String password = scan.nextLine();
		System.out.println("Please fill  email below");
		String email = scan.nextLine();
		Integer roleId = 2;
		userDto dto = new userDto();
		dto.setUserName(username);
		dto.setPassWord(password);
		dto.setRoleId(roleId);
		dto.setEmail(email);
		add(dto);
		System.out.println("Register success full!");

	}

	public void editUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input username you need to update");
		String username = scan.nextLine();
		System.out.println("Please fill new password update below");
		String password = scan.nextLine();
		System.out.println("Please fill new email update below");
		String email = scan.nextLine();
		Integer roleId = 1;
		userDto dto = new userDto();
		dto.setUserName(username);
		dto.setPassWord(password);
		dto.setEmail(email);
		dto.setRoleId(roleId);
		update(dto);
		System.out.println("update user success!");
	}

	public void editAdmin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input username you need to update");
		String username = scan.nextLine();
		userDto dto = findUser(username);
		if (dto.getUserName() != null) {
			System.out.println("Please fill new password update below");
			String password = scan.nextLine();
			System.out.println("Please fill new email update below");
			String email = scan.nextLine();
			Integer roleId = dto.getRoleId();
			dto.setUserName(username);
			dto.setPassWord(password);
			dto.setEmail(email);
			dto.setRoleId(roleId);
			update(dto);
			System.out.println("update user success!");
		}
		System.out.println("username not exist! please check agin!");

	}

	public void findUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input username you need to find");
		String username = scan.nextLine();
		userDto dto = findUser(username);
		System.out.println("User name : " + dto.getUserName());
		System.out.println("Password : " + dto.getPassWord());
		System.out.println("Password : " + dto.getEmail());
		if (dto.getRoleId() == 1) {
			System.out.println("Role : admin ");
		} else {
			System.out.println("Role : client");
		}

	}

	public userDto findEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input your username");
		String username = scan.nextLine();
		userDto dto = findUser(username);
//		System.out.println("User name : " + dto.getUserName());
//		System.out.println("Password : "+ dto.getPassWord());
		return dto;

	}

	public void showOptionAdmin() {
		System.out.println("Well come back admin area");
		System.out.println("Dictionary System Demo Version 0.001");
		System.out.println(" ----------------------------------");
		System.out.println("1. Add new user");
		System.out.println("2. Find user");
		System.out.println("3. Edit user");
		System.out.println("0. Exits");
		System.out.println(" ----------------------------------");
		System.out.print("Please choose: ");
	}

	public void showConfirm() {
		String confirm = null;
		System.out.println("You want to exist system or back menu admin ?");
		System.out.println("1. Back");
		System.out.println("2. Exist");
		Scanner scan = new Scanner(System.in);
		confirm = scan.nextLine();
		switch (confirm) {
		case "1":
			System.out.println("Wating... back to menu admin");
			break;
		case "2":
			System.out.println("Close system");
			break;
		default:
			System.out.println("invalid! please choose action in below menu:");
			break;
		}
	}

	public userDto findUser(String userName) {
		try {
			userDto dto = new userDto();
			String queryString = "Select * from user where username=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, userName);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(userName)) {
					dto.setUserName(resultSet.getString("username"));
					dto.setPassWord(resultSet.getString("password"));
					dto.setRoleId(resultSet.getInt("roleId"));
					dto.setEmail(resultSet.getString("email"));
				}
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
					ptmt.close();
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
		return null;
	}

	public boolean checkUserExist(String username) {
		userDto dto = findUser(username);

		if (dto.getUserName() != null) {
			System.out.println("Username available!");
			return false;
		}
		System.out.println("You can use username to register!");
		System.out.println("----------------------------------");
		addNewUser(username);
		return true;

	}

}
