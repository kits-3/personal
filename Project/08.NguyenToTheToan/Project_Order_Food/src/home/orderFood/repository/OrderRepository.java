package home.orderFood.repository;

import java.util.List;

import home.orderFood.entity.OrderEntity;


public interface OrderRepository {
	List<OrderEntity> findAll();
	OrderEntity findById(int id);
	int update();
	int delete();
}
