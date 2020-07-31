package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdminEntity.ProductAdmin;
import ConnectionFactory.ConnectionFactory;
import entity.Product;

public class ProductManageImpl implements ProductManageDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<ProductAdmin> findAll() {
		try {
			String queryString = "select * from product ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<ProductAdmin> dtoList = new ArrayList<ProductAdmin>();
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
	public void delete(int id) {
		try {
			String queryString = "delete from product where id = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);		
			ptmt.executeUpdate();
			System.out.println(" ");
			System.out.println("Delete product success!!");
			System.out.println(" ");
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
	public void update(ProductAdmin dto) {
		try {
			String queryString = "update product set cate_id=?, name=?, price=?, detail=? "
								 + "where id=?";
								 
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, dto.getCate_id());
			ptmt.setString(2, dto.getName());
			ptmt.setInt(3, dto.getPrice());
			ptmt.setString(4, dto.getDetail());
			ptmt.setInt(5, dto.getId());

			ptmt.executeUpdate();
			System.out.println(" ");
			System.out.println("Update product success!!");
			System.out.println(" ");
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
	public void add(ProductAdmin pro) {
		try {
			String queryString = "INSERT INTO product(cate_id,name,price,detail)"+ "VALUES(?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setInt(1, pro.getCate_id());
			ptmt.setString(2, pro.getName());
			ptmt.setInt(3, pro.getPrice());
			ptmt.setString(4, pro.getDetail());
			
			ptmt.executeUpdate();
			System.out.println("Add product success!!");

			
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
	public void selectBill(ProductAdmin pro) {
		try {
			String queryString = " select * from customer ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);		
			
			resultSet = ptmt.executeQuery();
			while(resultSet.next()) {
				System.out.println( "Id: "+resultSet.getInt("id")
									+" / Name: "+resultSet.getString("name")
									+" / address: "+resultSet.getString("address")
									+" / phone: "+resultSet.getInt("phone")
									+" / order_item:"+resultSet.getString("order_item")
									+" / total: "+resultSet.getString("total")
									+" / order_date: "+resultSet.getString("order_date"));
			}
			
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

}
