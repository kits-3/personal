package shoeshop.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shoeshop.config.ConnectionFactory;
import shoeshop.entity.UserEntity;
import shoeshop.entity.ProductEntity;

public class ProductRepositoryImpl implements ProductRepository{
	
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<ProductEntity> findProduct() {
		List<ProductEntity> lsProduct = new ArrayList<>();
		String queryString = "SELECT * FROM product";
		
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			rs = stmt.executeQuery(); //Select
			
			while(rs.next()) {
				ProductEntity pro = new ProductEntity();
				
				pro.setProductID(rs.getInt("ProductID"));
				pro.setProductName(rs.getString("ProductName"));
				pro.setProductPrice(rs.getInt("ProductPrice"));
				pro.setProductQuantity(rs.getInt("ProductQuantity"));
				
				lsProduct.add(pro);
			}
	
		} catch (SQLException e) {
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

	@Override
	public ProductEntity findById(int id) {
		ProductEntity product = new ProductEntity();
		String queryString = "select * from product where ProductID=?";
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				product.setProductID(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setProductPrice(rs.getInt("ProductPrice"));
				product.setProductQuantity(rs.getInt("ProductQuantity"));
			}
			connection.close();
		} catch (SQLException e) {
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
		
		
		return product;
	}
	public ProductEntity findByName(String name) {
		ProductEntity product = new ProductEntity();
		String queryString = "select * from product where ProductName=?";
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				product.setProductID(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setProductPrice(rs.getInt("ProductPrice"));
				product.setProductQuantity(rs.getInt("ProductQuantity"));
			}
			connection.close();
		} catch (SQLException e) {
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
		
		
		return product;
	}

	@Override
	public void addProduct(ProductEntity pe) {
		try{
			String queryString="INSERT INTO"
					+ " product(ProductID,ProductName,ProductPrice,ProductQuantity)"
					+ "VALUES(?,?,?,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,pe.getProductID());
			stmt.setString(2, pe.getProductName());
			stmt.setInt(3, pe.getProductPrice());
			stmt.setInt(4, pe.getProductQuantity());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void showProduct(List<ProductEntity> listEntity) {
		for(int i = 0 ; i < listEntity.size();i++){
			System.out.printf("%-10s","ID:"+listEntity.get(i).getProductID());
			System.out.printf("%-40s","Product Name: "+listEntity.get(i).getProductName());
			System.out.printf("%-15s","Price: "+listEntity.get(i).getProductPrice());
			System.out.printf("%-3s %n","Stock: "+listEntity.get(i).getProductQuantity());
		}
	}
	@Override
	public void showProductU(List<ProductEntity> listEntity) {
		for(int i = 0 ; i < listEntity.size();i++){
			System.out.printf("%-10s","ID:"+listEntity.get(i).getProductID());
			System.out.printf("%-40s","Product Name: "+listEntity.get(i).getProductName());
			System.out.printf("%-15s %n","Price: "+listEntity.get(i).getProductPrice());
		}
	}

	@Override
	public void deleteProduct(int id) {
		try{
			String queryString="delete from product where ProductID=?";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1,id);
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateProduct(ProductEntity pe) {
		try{
			String queryString=" UPDATE product set ProductName=?,ProductPrice=?,ProductQuantity=? WHERE ProductID=?";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, pe.getProductName());
			stmt.setInt(2, pe.getProductPrice());
			stmt.setInt(3, pe.getProductQuantity());
			stmt.setInt(4, pe.getProductID());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int getMaxItem() {
		try{
			String queryString="SELECT COUNT(ProductID) FROM product ";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null ) {
					stmt.close();
				}
				if (connection != null){
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<ProductEntity> findByNameM(String name) {
		List<ProductEntity> ls_product = new ArrayList();
		String queryString = "select * from product where ProductName LIKE ?";
		try {
			connection = getConnection();
			
			stmt = connection.prepareStatement(queryString);
			stmt.setString(1, name+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ProductEntity pro = new ProductEntity();
				
				pro.setProductID(rs.getInt("ProductID"));
				pro.setProductName(rs.getString("ProductName"));
				pro.setProductPrice(rs.getInt("ProductPrice"));
				pro.setProductQuantity(rs.getInt("ProductQuantity"));
				
				ls_product.add(pro);
			}
			connection.close();
		} catch (SQLException e) {
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
		return ls_product;
	}

}
