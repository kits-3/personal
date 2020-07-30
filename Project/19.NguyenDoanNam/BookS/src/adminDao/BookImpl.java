package adminDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import entity.Book;

public class BookImpl implements BookDao {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public Book findById(Integer Book_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		try {
			String queryString = "SELECT * from books where Status = 1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.print("Book_id: " + result.getInt(1) + " | ");
				System.out.print(" Book_name: " + result.getString(2) + " | ");
				System.out.print(" Athor: " + result.getString(3) + " | ");
				System.out.print(" Price: " + result.getInt(4) + " | ");
				System.out.print(" Amount: " + result.getInt(5) + " | ");
				System.out.println(" Category_id: " + result.getInt(6) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void add(Book book) {
		try {
			String queryString = "INSERT INTO books(Book_name, Athor, Price, Amount, Category_id,Status)"
					+ "VALUES(?,?,?,?,?,1)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, book.getBook_name());
			ptmt.setString(2, book.getAthor());
			ptmt.setInt(3, book.getPrice());
			ptmt.setInt(4, book.getAmount());
			ptmt.setInt(5, book.getCategory_id());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Add success");
					ptmt.close();
				} else {
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
	public void update(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer Book_id) {
		try {
			String queryString = "UPDATE books SET Status=0 where Book_id = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, Book_id);
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					System.out.println("Delete success");
					ptmt.close();
				} else {
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

}
