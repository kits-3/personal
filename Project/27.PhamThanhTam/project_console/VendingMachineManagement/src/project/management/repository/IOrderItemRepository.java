package project.management.repository;

import java.util.List;

import project.management.entity.OrderItemEntity;

public interface IOrderItemRepository extends GenericRepository<OrderItemEntity> {
	int add( OrderItemEntity orderItemEntity);
	OrderItemEntity findOne(int newId);
	List<OrderItemEntity> findOrderitemByMachineid(int id);
}
