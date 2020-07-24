package kits.personal.repository;

import java.util.List;

import kits.personal.entity.User;

public interface UserRepository {
	List<User> findAll();
	User findById(int id);
	int update(User user);
	void delete(int id);
	void add(User user);
	User checkUsername(String username);
}
