package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import Model.ConnectionFactory;

import entity.User;

public class UserImpl implements UserDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public User findById(String User_id, Integer pass) {
		return null;
	}

	@Override
	public List<User> findAll() {
		try {
			String queryString = "SELECT * from user WHERE Status = 1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print("Gmail: " + result.getString(1) + " | ");
				System.out.print(" Password: " + result.getInt(2) + " | ");
				System.out.println(" Role: " + result.getInt(3) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(User user) {
		try {
			String queryString = "INSERT INTO user(Gmail, Password, Id_role, Status)"
					+ "VALUES(?,?,?,1)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user.getGmail());
			ptmt.setInt(2, user.getPassword());
			ptmt.setInt(3, user.getId_role());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Add success");
					ptmt.close();
				} else
				{
					System.out.println("Add faild");
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
	public void update(User user) {
		try {
			String queryString = "UPDATE user SET Password=?, Id_role= ?, Status = ? where Gmail=? ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, user.getPassword());
			ptmt.setInt(2, user.getId_role());
			ptmt.setInt(1, user.getStatus());
			ptmt.setString(1, user.getGmail());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Delete success");
					ptmt.close();
				} else
				{
					System.out.println("Delete faild");
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
	public void delete(String gmail) {
		try {
			String queryString = "UPDATE user SET Status=0 where Gmail=? ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, gmail);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Delete success");
					ptmt.close();
				} else
				{
					System.out.println("Delete faild");
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
