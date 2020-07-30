package home.bike.repository;

import java.util.List;

import home.bike.entity.ProductEntity;

public interface ProductRepository {
	List<ProductEntity> findAll();
	ProductEntity findById(int id_product );
	int update();
	int delete();
}
