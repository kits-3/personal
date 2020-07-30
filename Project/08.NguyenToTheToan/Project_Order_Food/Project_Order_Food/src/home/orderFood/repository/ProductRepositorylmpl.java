package home.orderFood.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.orderFood.config.ConnectionFactory;
import home.orderFood.entity.ProductEntity;



public class ProductRepositorylmpl implements ProductRepository {
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity> lsProduct = new ArrayList();
		String queryString = "SELECT * FROM product";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				ProductEntity ad = new ProductEntity();
				ad.setCodeProduct(rs.getString("Code Product:"));
				ad.setNameProduct(rs.getString("Name Product:"));
				ad.setAmountProduct(rs.getString("Price Product:"));
				ad.setSpeciesProduct(rs.getString("Species Product"));
				
				
				
				lsProduct.add(ad);
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
		return lsProduct;
	}

	private void add(ProductEntity ad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductEntity findById(int id) {
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
