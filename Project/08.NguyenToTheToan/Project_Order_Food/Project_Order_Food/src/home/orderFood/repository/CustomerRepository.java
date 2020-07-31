package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.CustomerEntity;

public interface CustomerRepository {
	List<CustomerEntity> findAll();
	CustomerEntity findById(int id);
	int update();
	int delete();
}

