package customerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ConnectionFactory;
import customer.BillView_cus;
import entity.Book;

public class BookDaoImpl_cus implements BookDao_cus {
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet result = null;
	BillView_cus bill = new BillView_cus();
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	@SuppressWarnings("null")
	@Override
	public List<Book> findbyBook_name(String gmail, String book_name, List<Book> list) {
		try {
			String sql = "SELECT * FROM books WHERE Book_name = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, book_name);
			result = ptmt.executeQuery();
			Book book = new Book();
			
			System.out.println("------------------------------------------");
			
			if( result.next()) {
					System.out.print("Name book: " + result.getString(2) + " | ");
					System.out.print(" Athor: " + result.getString(3) + " | ");
					System.out.println(" Price: " + result.getString(4) + " | ");
					book.setBook_id(result.getInt(1));
					book.setBook_name(result.getString(2));
					book.setAthor(result.getString(3));
					book.setPrice(result.getInt(4));	
					list.add(book);
			}
			System.out.println("------------------------------------------");
			return list;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
