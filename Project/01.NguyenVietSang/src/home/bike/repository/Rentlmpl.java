package home.bike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.bike.config.ConnectionFactory;
import home.bike.entity.ProductEntity;
import home.bike.entity.RentEntity;

public class Rentlmpl implements RenRepository {
	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;

	private Connection getConnection1() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<RentEntity> findAll() {

		List<RentEntity> lispro = new ArrayList<RentEntity>();
		String queryString = "Select * from rent_info";
		try {
			connection = getConnection1();
			ptmt = connection.prepareStatement(queryString);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				RentEntity ren = new RentEntity();
				ren.setRent_id(rs.getInt("rent_id"));
				ren.setCustomer_id(rs.getInt("customer_id"));
				ren.setProduct_id(rs.getInt("product_id"));
				ren.setCheckin_date(rs.getDate("checkin_date"));
				ren.setCheckout_date(rs.getDate("checkout_date"));
				lispro.add(ren);

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
	public RentEntity findById(int id_product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
