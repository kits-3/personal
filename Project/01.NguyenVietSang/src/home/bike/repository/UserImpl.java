package home.bike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.bike.config.ConnectionFactory;
import home.bike.entity.ProductEntity;
import home.bike.entity.UserEntity;

public class UserImpl implements UserRepository {

	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;

	private Connection getConnection1() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<UserEntity> finAll() {
		List<UserEntity> lispro = new ArrayList<UserEntity>();
		String queryString = "Select * from user_info";
		try {
			connection = getConnection1();
			ptmt = connection.prepareStatement(queryString);
			rs = ptmt.executeQuery();
			while (rs.next()) {

				UserEntity user = new UserEntity();
				user.setId_customer(rs.getInt("id_customer"));
				user.setName(rs.getString("name"));
				user.setId_card(rs.getInt("id_card"));
				user.setPhone(rs.getInt("phone"));
				user.setAdd(rs.getString("add"));
				user.setUser(rs.getNString("user"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
				return lispro;
			}
			return lispro;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					// dong ket noi
					connection.close();
				}
				if (ptmt != null) {
					// dong preparedStatement
					ptmt.close();
				}
				if (rs != null) {
					// dong result set
					rs.close();
				}
			} catch (SQLException e) {

			}

		}
		return null;
	}

	@Override
	public UserEntity findById(int id_customer) {

		String queryString = "Select * from user_info where id_customer = ?";
		try {
			connection = getConnection1();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_customer);

			rs = ptmt.executeQuery();
			while (rs.next()) {
				UserEntity user = new UserEntity();
				user.setId_customer(rs.getInt("id_customer"));
				user.setName(rs.getString("name"));
				user.setId_card(rs.getInt("id_card"));
				user.setPhone(rs.getInt("phone"));
				user.setAdd(rs.getString("add"));
				user.setUser(rs.getString("user"));
				user.setPassword(rs.getString("password"));
				user.setRole_id(rs.getInt("role_id"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					// dong ket noi
					connection.close();
				}
				if (ptmt != null) {
					// dong preparedStatement
					ptmt.close();
				}
				if (rs != null) {
					// dong result set
					rs.close();
				}
			} catch (SQLException e) {

			}

		}
		return null;
	}

	public UserEntity findByUserName(String user) {

		String queryString = "Select * from user_info where user = ?";
		try {
			connection = getConnection1();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, user);

			rs = ptmt.executeQuery();
			while (rs.next()) {
				UserEntity user1 = new UserEntity();
				user1.setId_customer(rs.getInt("id_customer"));
				user1.setName(rs.getString("name"));
				user1.setId_card(rs.getInt("id_card"));
				user1.setPhone(rs.getInt("phone"));
				user1.setAdd(rs.getString("add"));
				user1.setUser(rs.getString("user"));
				user1.setPassword(rs.getString("password"));
				user1.setRole_id(rs.getInt("role_id"));
				return user1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					// dong ket noi
					connection.close();
				}
				if (ptmt != null) {
					// dong preparedStatement
					ptmt.close();
				}
				if (rs != null) {
					// dong result set
					rs.close();
				}
			} catch (SQLException e) {

			}

		}
		return null;
	}

	@Override
	public int update() {
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
}
