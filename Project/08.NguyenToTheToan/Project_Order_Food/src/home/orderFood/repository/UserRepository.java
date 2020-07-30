package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.UserEntity;



public interface UserRepository {
	List<UserEntity> findAll();
	UserEntity findById(int id);
	int update();
	int delete();
	void add(UserEntity e);
	UserEntity get(UserEntity e);
}
