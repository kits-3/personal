package customerDao;

import java.util.List;

import entity.Book;
import entity.Category_book;

public interface CategoryDao_cus {
	
	
	Book findBy_category(String gmail, String category_name, List<Book> list);
	List<Category_book> findAll();


}
