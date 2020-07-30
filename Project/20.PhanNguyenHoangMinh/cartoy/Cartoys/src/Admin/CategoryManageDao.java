package Admin;

import java.util.List;

import AdminEntity.CategoryAdmin;

public interface CategoryManageDao {
	
	List<CategoryAdmin> findAll();
	void update(CategoryAdmin dto);
	void delete(int id);
	void addName(String name);

}
