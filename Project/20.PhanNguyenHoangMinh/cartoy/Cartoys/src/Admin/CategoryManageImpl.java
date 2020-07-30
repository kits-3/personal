package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdminEntity.CategoryAdmin;
import ConnectionFactory.ConnectionFactory;

public class CategoryManageImpl implements CategoryManageDao {
	
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<CategoryAdmin> findAll() {
		try {
			String queryString = "select * from category ";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			List<CategoryAdmin> dtoList = new ArrayList<CategoryAdmin>();

			while (resultSet.next()) {
				
				System.out.println("id: "+resultSet.getInt("id")
								  +" name: "+resultSet.getString("name"));

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
	public void update(CategoryAdmin dto) {
		try {
			String queryString = "update category set name=?"
								 + "where id=?";
								 
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, dto.getName());
			ptmt.setInt(2, dto.getId());

			ptmt.executeUpdate();
			System.out.println(" ");
			System.out.println("Update category success!!");
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
	public void delete(int id) {
		try {
			String queryString = "delete from category where id = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, id);		
			ptmt.executeUpdate();
			System.out.println("Delete category success!!");
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
	public void addName(String name) {
		try {
			String queryString = "INSERT INTO category(name)"+ "VALUES(?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);

			ptmt.setString(1, name);

			ptmt.executeUpdate();
			System.out.println("Add category success!!");
//			CategoryAdmin cateAd = new CategoryAdmin();
			
//			while (resultSet.next()) {
//
//				cateAd.setName(resultSet.getString(2));
//		
//			}
			
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
}
