package vending.project.repository.user;

import java.util.List;
import java.util.Optional;

import vending.project.entity.user.User;

public interface UserRepository {
	void add(User user);
	List<User> findAll();
	void update(User user);
	void delete(int id);
	User login(); // 로긴  ID, PW 를 입력받아서 User 를 반환한다..... 
	
}
