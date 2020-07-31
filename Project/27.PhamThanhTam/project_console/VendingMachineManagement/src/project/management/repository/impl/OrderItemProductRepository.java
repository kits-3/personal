package project.management.repository.impl;

import java.util.List;

import project.management.entity.OrderItemProductEntity;
import project.management.mapper.OrderItemProductMapper;
import project.management.repository.IOrderItemProductRepository;

public class OrderItemProductRepository extends AbstrachRepository<OrderItemProductEntity> implements IOrderItemProductRepository{

	@Override
	public int addOrderItemProduct(OrderItemProductEntity orderItemProductEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO orderitem_product ");
		sql.append(" (productid, orderitemid, count)");
		sql.append(" VALUES(?, ?, ?)");
		return insert(sql.toString(), orderItemProductEntity.getProductid(),orderItemProductEntity.getOrderid(), orderItemProductEntity.getCountOrdered());
	}

	@Override
	public OrderItemProductEntity findOne(int newId) {
		String sql = "SELECT * FROM  orderitem where id = ?";
		List<OrderItemProductEntity>  orderItemProductEntities = query(sql, new OrderItemProductMapper(), newId);
		return orderItemProductEntities.isEmpty() ? null : orderItemProductEntities.get(0);
	}

	@Override
	public List<OrderItemProductEntity> findOrderitemByMachineid(int id) {
		String sql = "SELECT * FROM  orderitem_product where orderitemid = ?";
		List<OrderItemProductEntity>  orderItemProductEntities = query(sql, new OrderItemProductMapper(), id);
		return orderItemProductEntities;
	}	
}
