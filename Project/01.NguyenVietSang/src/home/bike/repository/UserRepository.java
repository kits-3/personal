package home.bike.repository;

import java.util.List;

import home.bike.entity.UserEntity;

public interface UserRepository {
	List<UserEntity> finAll();

	UserEntity findById(int id_customer);

	int update();

	int delete();
	
	UserEntity findByUserName(String user);
}
