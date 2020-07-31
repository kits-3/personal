package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.ProductEntity;
import home.orderFood.entity.storeEntity;

public interface ProductRepository {
	List<ProductEntity> findAll();
	storeEntity findById(int id);
	int update();
	int delete();
	void add(ProductEntity e);
	ProductEntity get(ProductEntity e);
}
