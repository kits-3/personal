package home.bike.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.bike.config.ConnectionFactory;
import home.bike.entity.ProductEntity;

public class ProductImpl implements ProductRepository {

	private Connection connection = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;

	private Connection getConnection1() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> lispro = new ArrayList<ProductEntity>();
		String queryString = "Select * from product_info";
		try {
			connection = getConnection1();
			ptmt = connection.prepareStatement(queryString);
			rs = ptmt.executeQuery();
			while (rs.next()) {

				ProductEntity pro = new ProductEntity();

				pro.setId_product(rs.getInt("id_product"));
				pro.setColor(rs.getString("color"));
				pro.setPirce(rs.getFloat("price"));
				pro.setTrademark(rs.getString("trademark"));
				lispro.add(pro);

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

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity findById(int id_product) {
		
		String queryString = "Select * from product_info where id_product = ?";
		try {
			connection = getConnection1();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id_product);
			rs = ptmt.executeQuery();
			

			while (rs.next()) {

				ProductEntity pro = new ProductEntity();

				pro.setId_product(rs.getInt("id_product"));
				pro.setColor(rs.getString("color"));
				pro.setPirce(rs.getFloat("price"));
				pro.setTrademark(rs.getString("trademark"));
				
				return pro;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
