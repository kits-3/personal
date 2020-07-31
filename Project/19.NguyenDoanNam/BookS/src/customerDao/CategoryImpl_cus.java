package customerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Model.ConnectionFactory;
import customer.BookView_cus;
import entity.Book;
import entity.Category_book;

public class CategoryImpl_cus implements CategoryDao_cus {

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;
	BookView_cus bookview_cus = new BookView_cus();

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@Override
	public List<Category_book> findAll() {
		try {
			String queryString = "SELECT * from book_category where Status = 1";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			result = ptmt.executeQuery();
			while (result.next()) {
				System.out.println(" Category_name: " + result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book findBy_category(String gmail, String category_name, List<Book> list) {
		try {
			String sql = "SELECT * FROM books WHERE category_id = (SELECT category_id FROM book_category WHERE Name_category = ?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, category_name);
			result = ptmt.executeQuery();

			System.out.println("------------------------------------------");
			while (result.next()) {

				System.out.print("Name book: " + result.getString(2) + " | ");
				System.out.print(" Athor: " + result.getString(3) + " | ");
				System.out.println(" Price: " + result.getString(4) + " | ");
			}
			System.out.println("------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null) {
					ptmt.close();
				} else {
					System.out.println("ERROR");
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
