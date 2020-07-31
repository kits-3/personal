package adminDao;

import java.util.List;

import entity.User;

public interface UserDao {

	User findById(String User_id, Integer pass);

	List<User> findAll();

	void add(User user);

	void update(User user);

	void delete(String gmail);
}
