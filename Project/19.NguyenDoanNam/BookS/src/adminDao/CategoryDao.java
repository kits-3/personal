package adminDao;

import java.util.List;

import entity.Category_book;

public interface CategoryDao {

	Category_book findById(Integer Category_id);

	List<Category_book> findAll();

	void add(Category_book ct);

	void update(Category_book ct);

	void delete(String Name_category);
	
	void delete_book();

}
