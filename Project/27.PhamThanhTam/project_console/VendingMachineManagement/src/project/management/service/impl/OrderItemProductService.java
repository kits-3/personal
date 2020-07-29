package project.management.service.impl;

import project.management.entity.OrderItemProductEntity;
import project.management.repository.IOrderItemProductRepository;
import project.management.repository.impl.OrderItemProductRepository;
import project.management.service.IOrderItemProductService;

public class OrderItemProductService implements IOrderItemProductService{
	IOrderItemProductRepository orderItemProductRepository = new OrderItemProductRepository();
	@Override
	public OrderItemProductEntity addOrderItemProduct(OrderItemProductEntity orderItemProductEntity) {
		int newId = orderItemProductRepository.addOrderItemProduct(orderItemProductEntity);
		return orderItemProductRepository.findOne(newId);
	}

}
