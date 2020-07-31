package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.ProductEntity;



public interface ProductRepository {
	List<ProductEntity> findAll();
	ProductEntity findById(int id);
	int update();
	int delete();
}
