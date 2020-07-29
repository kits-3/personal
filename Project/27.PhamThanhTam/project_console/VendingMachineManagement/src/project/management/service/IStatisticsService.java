package project.management.service;

import java.util.List;

import project.management.entity.OrderItemEntity;
import project.management.entity.OrderItemProductEntity;
import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;

public interface IStatisticsService {
	List<ProductEntity> findByMachine(int machineID);
	List<StoreMachineEntity> findAllMachine ();
	ProductEntity findMinByProductprice(int id);
	List<OrderItemEntity> findOrderitemByMachineid(int id);
	List<OrderItemProductEntity> findProductByOrderitem(int id);
}