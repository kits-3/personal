package home.computer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import home.computer.config.connectionFactory;
import home.computer.entity.productEntity;

public class productRepositoryImpl implements productRepository {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet result = null;
	Scanner sc = new Scanner(System.in);
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = connectionFactory.getInstance().getConnection();
		return conn;
		
	}
	
	@Override
	public void select() {
		List<productEntity> productLs = new ArrayList<productEntity>();
		
		try {
			String queryString = "SELECT * FROM product";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			result = statement.executeQuery();
			
			while(result.next())
			{
				productEntity product = new productEntity();
				product.setId(result.getInt("id"));
				product.setId_category(result.getString("id_category"));
				product.setProductName(result.getString("ProductName"));
				product.setUnitPrice(result.getInt("UnitPrice"));
				product.setUnitInStock(result.getInt("UnitInStock"));
				
				productLs.add(product);
			}
			for (int i = 0; i < productLs.size(); i++)
			{
				System.out.print("id: ");
				System.out.printf("%-10s",productLs.get(i).getId());
				System.out.print(" | id_category: ");
				System.out.printf("%-10s",productLs.get(i).getId_category());
				System.out.print(" | ProductName: ");
				System.out.printf("%-70s",productLs.get(i).getProductName());
				System.out.printf("%-10s", " | UnitPrice: ");
				System.out.printf("%-10s",productLs.get(i).getUnitPrice());
				System.out.print(" | UnitInStock: ");
				System.out.println(productLs.get(i).getUnitInStock());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void insert() {
				try {
					
					System.out.print("Input product idcategory: ");
					String idcategory = sc.next();
					System.out.print("Input product productname: ");
					String productname = sc.next();
					System.out.print("Input product UnitPrice: ");
					int UnitStock = sc.nextInt();
					System.out.print("Input product UnitStock: ");
					int UnitPrice = sc.nextInt();
					
					String queryString = "INSERT INTO" + " product(id_category,ProductName,UnitPrice,UnitInStock) "
							+ " VALUES (?,?,?,?) ";
					connection = getConnection();
					
					statement = connection.prepareStatement(queryString);
					statement.setString(1,idcategory);
					statement.setString(2,productname);
					statement.setInt(3,UnitStock);
					statement.setInt(4,UnitPrice);
					statement.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Insert fail-------Input idcategory not valid");
				}
				finally {
					try {
						if(statement != null){
							statement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
		
	}
	
	@Override
	public void update() {
		
		try {
			
			String idcategory = "";
			String productname = "";
			int UnitPrice = 0;
			int UnitStock = 0;
			System.out.print("Input id to update ");
			int id = sc.nextInt();
			String checkid = chooseProduct(id).getProductName();
			if(checkid == null)
			{
				System.out.println("id not found");
			}
			else
			{
				System.out.print("Input product idcategory: ");
				idcategory = sc.next();
				System.out.print("Input product productname: ");
				productname = sc.next();
				System.out.print("Input product UnitPrice: ");
				UnitPrice = sc.nextInt();
				System.out.print("Input product UnitStock: ");
				UnitStock = sc.nextInt();
			}
			
			String queryString = "UPDATE product set id_category=?, ProductName=?, UnitPrice=?, UnitInStock=? where id=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setString(1, idcategory);
			statement.setString(2, productname);
			statement.setInt(3, UnitPrice);
			statement.setInt(4, UnitStock);
			statement.setInt(5,id );
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update fail-------Input idcategory not valid");
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void updateUnitInStock(int UnitInStock, int id) {
		try {
			String queryString = "UPDATE product SET UnitInStock=? WHERE id=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setInt(1, UnitInStock);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void delete() {
		try {
			System.out.print("Input id to Delete: ");
			int id = sc.nextInt();
			String queryString = "DELETE FROM product WHERE id=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void menu() {
		List<productEntity> productLs = new ArrayList<productEntity>();
		
		try {
			String queryString = "SELECT * FROM product";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			result = statement.executeQuery();
			
			while(result.next())
			{
				productEntity product = new productEntity();
				product.setId(result.getInt("id"));
				product.setId_category(result.getString("id_category"));
				product.setProductName(result.getString("ProductName"));
				product.setUnitPrice(result.getInt("UnitPrice"));
				product.setUnitInStock(result.getInt("UnitInStock"));
				
				productLs.add(product);
			}
			for (int i = 0; i < productLs.size(); i++)
			{
				System.out.print(productLs.get(i).getId());
				System.out.print(" | ProductName: ");
				System.out.printf("%-70s ",productLs.get(i).getProductName());
				System.out.printf("%-5s","");
				System.out.print(" | Price: ");
				System.out.println(productLs.get(i).getUnitPrice());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public String findProduct() {
		List<productEntity> productLs = new ArrayList<productEntity>();
		String pro = "";
		try {
			
			System.out.println("Input product that you want to find");
			String findP = sc.next();
			String queryString = "SELECT id,ProductName,UnitPrice FROM product WHERE id_category=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setString(1, findP);
			result = statement.executeQuery();
			
			
			while(result.next())
			{
				productEntity product = new productEntity();
				product.setId(result.getInt("id"));
				product.setProductName(result.getString("ProductName"));
				product.setUnitPrice(result.getInt("UnitPrice"));
				productLs.add(product);
			}
			
			for (int i = 0; i < productLs.size(); i++)
			{
				System.out.print(productLs.get(i).getId());
				System.out.print(". ");
				System.out.printf("%-70s",productLs.get(i).getProductName());
				System.out.print(": ");
				System.out.print(productLs.get(i).getUnitPrice());
				System.out.println("$ ");
				pro += productLs.get(i).getProductName();
			}
			if (pro.isEmpty()){
				System.out.println("Couldn't find this product.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return pro;
		
	}
	
	@Override
	public productEntity chooseProduct(int chooseProduct) {
		productEntity product = new productEntity();
	
		
		try {
			String queryString = "SELECT ProductName,UnitPrice,UnitInStock FROM product WHERE id=?";
			connection = getConnection();
			statement = connection.prepareStatement(queryString);
			statement.setInt(1, chooseProduct);
			result = statement.executeQuery();
			
			if (result.next()) {
				product.setUnitPrice(result.getInt("UnitPrice"));
				product.setUnitInStock(result.getInt("UnitInStock"));
				product.setProductName(result.getString("ProductName"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if(statement != null){
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return product;
	}

}
