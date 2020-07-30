package customerDao;

import java.util.List;

import entity.Book;

public interface BookDao_cus {

	List<Book> findbyBook_name(String gmail, String book_name, List<Book> list);
}
