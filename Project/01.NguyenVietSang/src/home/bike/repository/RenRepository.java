package home.bike.repository;

import java.util.List;

import home.bike.entity.ProductEntity;
import home.bike.entity.RentEntity;

public interface RenRepository {
	List<RentEntity> findAll();

	RentEntity findById(int id_product);

	int update();

	int delete();
}
