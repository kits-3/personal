package Dao;

import java.util.List;

import entity.Product;

public interface ProductDao {
	
	Product findById1(int id);
//	Product findById1(int id);
	List<Product> findAll();
	void update(Product dto);
	void delete(int id);
	void add(Product dto);
	
}
