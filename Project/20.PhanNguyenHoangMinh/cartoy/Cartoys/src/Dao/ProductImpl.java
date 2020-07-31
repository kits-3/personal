package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectionFactory.ConnectionFactory;
import entity.Category;
import entity.Product;

public class ProductImpl implements ProductDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	

	@Override
	public List<Product> findAll() {
		try {
			String queryString = "select * from product ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<Product> dtoList = new ArrayList<Product>();
			int i=1;
			while (resultSet.next()) {
				
				System.out.println("id: "+resultSet.getInt("id")
								  +" / cate_id: "+resultSet.getInt("cate_id")
								  +" /  name: "+resultSet.getString("name")
								  +" /  price: "+resultSet.getInt("price")
								  +" /  detail: "+resultSet.getString("detail"));
				i++;
			}
			return dtoList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return null;
	}

	@Override
	public void update(Product dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		try {
			String queryString = "delete from product where id = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);		
			ptmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (ptmt != null) {
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
	public void add(Product dto) {
		try {
			String queryString = "INSERT INTO product(id,cate_id,name,price,brand_id)"
					+ "VALUES(?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, dto.getId());
			ptmt.setInt(2, dto.getId());
			ptmt.setString(3, dto.getName());
			ptmt.setInt(4, dto.getPrice());

			ptmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
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
	public Product findById1(int id) {
		try {
			String queryString = "select * from product where id = ? ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, id);
			
			resultSet = ptmt.executeQuery();
			Product product = new Product();
			
			System.out.println("No Name\t\t\tPrice\t\tDetail");
			System.out.println("------------------------------------------------------");
			while (resultSet.next()) {
				product.setName(resultSet.getString(3));
				product.setPrice(resultSet.getInt(4));
				product.setId(resultSet.getInt(1));
				System.out.println(""+resultSet.getInt("id")+". "+resultSet.getString("name")+"\t\t"+resultSet.getInt("price")+"\t\t"+resultSet.getString("detail"));
				
			}
			System.out.println("------------------------------------------------------");
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ptmt != null) {
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
		return null;
	}


}
