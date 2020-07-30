package shoeshop.repository;

import java.util.List;

import shoeshop.entity.UserEntity;
import shoeshop.entity.orderEntity;
import shoeshop.entity.orderItemEntity;

public interface OrderRepository {
	public void addOrder(List<orderItemEntity> oE, UserEntity user, orderEntity orderE);
	public int getTotal(orderEntity orderE);
}
