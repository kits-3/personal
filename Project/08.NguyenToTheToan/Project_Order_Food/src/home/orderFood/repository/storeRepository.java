package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.storeEntity;

public interface storeRepository {
	List<storeEntity> findAll();
	storeEntity findById(int id);
	int update();
	int delete();
	void add(storeEntity e);
	List<String> get();
}
