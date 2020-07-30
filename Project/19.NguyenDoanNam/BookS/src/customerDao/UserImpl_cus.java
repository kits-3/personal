package customerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import customer.BillView_cus;
import entity.Book;
import entity.User;

public class UserImpl_cus implements UserDao_cus {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public User findById(String gmail) {
		try {
			String sql = "SELECT Gmail,Password FROM user WHERE Gmail = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, gmail);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print("Gmail: " + result.getString(1) + " | ");
				System.out.println("Password: " + result.getInt(2) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(User user) {
		try {
			String queryString = "UPDATE user SET Password=? where Gmail=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, user.getPassword());
			ptmt.setString(2, user.getGmail());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Update new password success");
					
					ptmt.close();
				} else {
					System.out.println("Update fail");
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
	
	@Override
	public void update_money_bill(String Gmail, Integer total, Integer money_user) {
		try {
			String queryString = "UPDATE user SET Money=? where Gmail=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, money_user-total);
			ptmt.setString(2, Gmail);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
				
					ptmt.close();
				} else {
					System.out.println("Update fail");
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
	@Override
	public void update_money_small(String Gmail , List<Book> list , Integer money_user, Integer new_money) {
		try {
			String queryString = "UPDATE user SET Money=? where Gmail=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, money_user + new_money);
			ptmt.setString(2, Gmail);
			ptmt.executeUpdate();
			System.out.println("Insert success!");
			new BillView_cus().upBill(Gmail, list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					
					
					ptmt.close();
				} else {
					System.out.println("Update fail");
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
}
