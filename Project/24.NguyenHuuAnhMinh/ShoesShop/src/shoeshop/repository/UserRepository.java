package shoeshop.repository;

import java.util.List;

import shoeshop.entity.UserEntity;
import shoeshop.entity.ProductEntity;

public interface UserRepository {
	List<UserEntity> findAll();
	UserEntity findById(int id);
	public UserEntity login(String id, String pwd);
	public void addUser(UserEntity ce);
	public void updateMoney(UserEntity ce);
	public void signUp(UserEntity user , List<UserEntity> list_user,UserRepository userRepo);
	public void updateAll(UserEntity ce);
	public void showUser(List<UserEntity> listEntity); 
}
