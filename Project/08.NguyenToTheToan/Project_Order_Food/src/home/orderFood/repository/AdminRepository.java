package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.AdminEntity;

public interface AdminRepository {
	List<AdminEntity> findAll();
	AdminEntity findById(int id);
	int update();
	int delete();
	
	
}
