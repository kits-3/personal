package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.ConnectionFactory;
import admin.Admin;
import admin.Home;
import admin.Login;
import customer.Customer;
import entity.User;

public class LoginImpl implements LoginDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;
	Admin ad = new Admin();
	Customer cus = new Customer();
	Home home = new Home();

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public User login(String gmail, Integer pass) {
		try {
			String sql = "Select * from user where Gmail=? AND Password=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, gmail);
			ptmt.setInt(2, pass);
			result = ptmt.executeQuery();
			if (result.next()) {
				int role = result.getInt(3);
				if (role == 1) {
					ad.notification();
				} else {
					cus.notification(gmail);
				}
			} else {
				System.out.println(" Login faild. Wrong username or password");
				System.out.println("------------------------------------------");
				home.view();
			}
		} catch (Exception e) {
			System.out.println(" Login faild. Error");
		}
		return null;
	}

	@Override
	public void add(User user) {
		try {
			String queryString = "INSERT INTO user(Gmail, Password, Id_role, Status)" + "VALUES(?,?,2,1)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getGmail());
			ptmt.setInt(2, user.getPassword());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Registration successful");
					System.out.println("------------------------------------------");
					home.view();
					ptmt.close();
				} else {
					System.out.println("Registration faild");
					System.out.println("------------------------------------------");
					home.view();
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
	public User forget_pw(String gmail) {
		try {
			String sql = "Select Password from user where Gmail=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, gmail);
			result = ptmt.executeQuery();
			if (result.next()) {
				System.out.print("Your password: " + result.getInt(1));
			} else {
				System.out.println("Faild. Account does not exist");
				System.out.println("------------------------------------------");
				home.view();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
