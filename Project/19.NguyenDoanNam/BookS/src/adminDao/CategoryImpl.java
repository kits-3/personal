package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import entity.Category_book;

public class CategoryImpl implements CategoryDao{
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	@Override
	public Category_book findById(Integer Category_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category_book> findAll() {
		try {
			String queryString = "SELECT * from book_category where Status = 1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print("Category_id: " + result.getInt(1) + " | ");
				System.out.println(" Category_name: " + result.getString(2) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(Category_book ct) {
		try {
			String queryString = "INSERT INTO book_category(Name_category, Status)"
					+ "VALUES(?,1)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, ct.getCatogory_name());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Add success");
					ptmt.close();
				} else
				{
					System.out.println("Add faild");
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
	public void update(Category_book ct) {
		try {
			String queryString = "UPDATE book_category SET Name_category=?, Status=? where Category_id = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, ct.getCatogory_name());
			ptmt.setInt(2, ct.getStatus());
			ptmt.setInt(3, ct.getCategory_id());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Update success");
					ptmt.close();
				} else
				{
					System.out.println("Update faild");
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
	public void delete(String Name_category) {
		try {
			String queryString = "UPDATE book_category SET Status=0 where Name_category = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, Name_category);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Delete success");
					ptmt.close();
				} else
				{
					System.out.println("Delete faild");
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
	public void delete_book() {
		try {
			String queryString = "UPDATE books SET Status=0 where Category_id = (SELECT category_id FROM book_category WHERE Status = 0)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {		
					ptmt.close();
				} else
				{
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
