package parkingSystem.repository;

import java.util.List;


import parkingSystem.entity.user;

public interface userRepository {
	List<user> findAll() ;
	void findById(int id);
	void update(user User);
	void add(user User);
	boolean validate(String name,String pass);
	boolean roll(String name);
	void delete(int id);
	void creatAccount(user User);
	boolean checkLoop(String username);
	int getID(String username);
	void findByIdAdmin(int a);
	void findAllAdmin();
}
