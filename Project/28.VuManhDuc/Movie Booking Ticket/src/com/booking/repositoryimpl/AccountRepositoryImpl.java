package com.booking.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.configuration.ConnectionFactory;
import com.booking.entity.AccountEntity;
import com.booking.repository.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	Scanner scanner = new Scanner(System.in);

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public AccountEntity checkAccount(String username, String password) {
		// TODO Auto-generated method stub
		String query = "select * from acc where user_name = ? and pass_word = ?";
		AccountEntity acc = new AccountEntity();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
//			rs.next();
			while (rs.next()) {
				acc.setIdUser(rs.getInt("id_user"));
				acc.setUsername(rs.getString("user_name"));
				acc.setPassword(rs.getString("pass_word"));
				acc.setRole(rs.getString("role"));
				acc.setNameOfUser(rs.getString("name_of_user"));
				acc.setAge(rs.getInt("age"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		return acc;
	}

	@Override
	public void insertAccount() {
		// TODO Auto-generated method stub
		String sql = "insert into acc(user_name, pass_word, role, name_of_user, age) values (?,?,?,?,?)";
		String username = null;
		String password1;
		String password2;
		String name;
		int age;
		List<AccountEntity> l = findAll();
		try {
			System.out.println("Register now!");
			boolean validate = true;
			do {
				System.out.print("Input username: ");
				username = scanner.next();
				validate = true;
				for (int j = 0; j < l.size(); j++) {
					if (username.equals(l.get(j).getUsername())) {
						validate = false;
						break;
					}
				}
			} while (!validate);

			do {
				System.out.print("Input password: ");
				password1 = scanner.next();
				System.out.print("Input password again: ");
				password2 = scanner.next();
				if (!password1.trim().equals(password2.trim()))
					System.out.println("Password does not match!");
			} while (!password1.trim().equals(password2.trim()));

			System.out.print("Input your name: ");
			name = scanner.next();
			System.out.print("Input your age: ");
			age = scanner.nextInt();

			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password1);
			stmt.setString(3, "user");
			stmt.setString(4, name);
			stmt.setInt(5, age);
			int result = stmt.executeUpdate();
			if(result > 0)
				System.out.println("Create Account Successfully!");
			else
				System.err.println("Create Account fail!");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
	public List<AccountEntity> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from acc";
		List<AccountEntity> list = new ArrayList<>();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				AccountEntity acc = new AccountEntity();
				acc.setIdUser(rs.getInt("id_user"));
				acc.setNameOfUser(rs.getString("name_of_user"));
				acc.setRole(rs.getString("role"));
				acc.setPassword(rs.getString("pass_word"));
				acc.setUsername(rs.getString("user_name"));
				list.add(acc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
		return list;
	}

}
