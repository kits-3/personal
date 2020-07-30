package shoeshop.repository;

import java.util.List;

import shoeshop.entity.ProductEntity;
import shoeshop.entity.UserEntity;
import shoeshop.entity.orderItemEntity;

public interface OrderItemRepository {
	public void addOderItem(ProductEntity proE, orderItemEntity oE, UserEntity user);
	public int getMaxID(orderItemEntity oE);
	public List<orderItemEntity> findOrderItem();
	public void showOrderItem(List<orderItemEntity> lsOrder);
}
