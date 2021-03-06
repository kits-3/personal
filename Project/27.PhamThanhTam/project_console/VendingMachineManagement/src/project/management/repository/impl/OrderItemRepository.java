package project.management.repository.impl;

import java.util.List;

import project.management.entity.OrderItemEntity;
import project.management.mapper.OrderItemMapper;
import project.management.repository.IOrderItemRepository;

public class OrderItemRepository extends AbstrachRepository<OrderItemEntity> implements IOrderItemRepository {

	@Override
	public int add(OrderItemEntity orderItemEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO orderitem ");
		sql.append(" ( moneytotal, storemachineid, status)");
		sql.append(" VALUES(?, ?, ?)");
		return insert(sql.toString(), orderItemEntity.getMoneytotal(),orderItemEntity.getStoremachineid(), orderItemEntity.getStatus());
	}

	@Override
	public OrderItemEntity findOne(int newId) {
		String sql = "SELECT * FROM  orderitem where id = ?";
		List<OrderItemEntity>  orderItemEntity = query(sql, new OrderItemMapper(), newId);
		return orderItemEntity.isEmpty() ? null : orderItemEntity.get(0);
	}

	@Override
	public List<OrderItemEntity> findOrderitemByMachineid(int id) {
		String sql = "SELECT * FROM  orderitem where storemachineid = ?";
		List<OrderItemEntity>  orderItemEntity = query(sql, new OrderItemMapper(), id);
		return  orderItemEntity;
	}
	
}
