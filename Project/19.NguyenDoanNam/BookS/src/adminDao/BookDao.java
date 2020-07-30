package adminDao;

import java.util.List;

import entity.Book;

public interface BookDao {
	
	Book findById(Integer Book_id);
	
	List<Book> findAll();
	
	void add(Book book);
	
	void update(Book book);

	void delete(Integer Book_id);
}
