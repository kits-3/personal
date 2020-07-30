package home.computer.repository;

import home.computer.entity.orderEntity;

public interface orderRepository {
	void insertOrder (String iduser,String idproduct);
	int findIdOrder(String iduser,String idproduct);
}
