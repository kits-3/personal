package parkingSystem.repository;

import java.util.List;

import parkingSystem.entity.user;

public interface userRepository {
	List<user> findAll();
	user findById(int id);
	int update();
	int delete();
}
