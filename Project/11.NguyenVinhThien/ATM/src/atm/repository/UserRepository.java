package atm.repository;

import java.util.List;

import atm.entity.User;

public interface UserRepository {
	
	int login(String username, String password);
	
	int create(User acc);
	
	int update(User acc);
	
	int delete(String id);
	
	int block(int id, int status);
	
	List<Integer> checkRole(int id);
	
	int setRole(int id, int role);
	
	int setUnRole(int id, int role);
	
	List<User> findAll();
	
	User findById(int id);
	
	User findByUser(String username);

	List<Double> getATM();
	
	int setATM(List<Double> list);
}
