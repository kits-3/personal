package repository;

import java.util.List;

import entity.User;

public interface UserRepository {
	
 void update(User us);
 void delete(int id);
 void signIn();
 void signUp();
 List<User> infoUser();
}
