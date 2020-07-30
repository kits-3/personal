package project.management.repository;

import java.util.List;

import project.management.entity.OrderItemProductEntity;

public interface IOrderItemProductRepository {
	int addOrderItemProduct(OrderItemProductEntity orderItemProductEntity);
	OrderItemProductEntity findOne(int newId);
	List<OrderItemProductEntity> findOrderitemByMachineid(int id);
}
