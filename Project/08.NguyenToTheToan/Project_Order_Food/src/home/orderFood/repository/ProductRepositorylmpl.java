package home.orderFood.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.orderFood.config.ConnectionFactory;
import home.orderFood.entity.ProductEntity;
import home.orderFood.entity.storeEntity;

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
		List<ProductEntity> lsProduct =new ArrayList<ProductEntity>();
		String queryString ="SELECT * FROM store";
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery();//select
			while(rs.next()) {
				ProductEntity ad = new ProductEntity();					
				ad.setId(rs.getInt("id"));
				ad.setNameProduct(rs.getString("nameProduct"));
				ad.setPriceProduct(rs.getInt("priceProduct"));
				ad.setQuantityProudct(rs.getString("quantityProduct"));
				ad.setTypeProduct(rs.getString("typeProduct"));
				
				lsProduct.add(ad);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}
		return lsProduct;
	}
	@Override
	public ProductEntity get(ProductEntity e) {
		//TODO Auto-generated method stub
		String queryString ="SELECT * FROM product WHERE nameProduct=? AND priceProduct=? AND quantityProduct=? AND typeProduct=?";
		ProductEntity ad =new ProductEntity();
		try {
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1,e.getNameProduct());
			stmt.setInt(2,e.getPriceProduct());
			stmt.setString(3,e.getQuantityProudct());
			stmt.setString(4,e.getTypeProduct());
			rs = stmt.executeQuery();//Select
			while(rs.next()) {
				ad.setNameProduct(rs.getString("nameProduct"));
				ad.setPriceProduct(rs.getInt("priceProduct"));
				ad.setQuantityProudct(rs.getString("quantityProduct"));
				ad.setTypeProduct(rs.getString("typeProduct"));
			}
			return ad;
			
		}catch(SQLException n) {
			n.printStackTrace();
			System.err.println("No database connection");
		}
		return ad;
	}
	
	
	@Override
	public storeEntity findById(int id) {
		return null;
	}
	
	@Override
	public int update() {
		//TODO auto-generated method stub
		return 0;
	}
	@Override
	public int delete() {
		//TODO Auto-generated method stub
		return 0;
		
	}
	@Override
	public void add(ProductEntity e) {
		// TODO Auto-generated method stub
		
	}
	
		
	
	
	
}
