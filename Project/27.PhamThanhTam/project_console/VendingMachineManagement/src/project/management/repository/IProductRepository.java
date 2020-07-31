package project.management.repository;

import java.util.List;

import project.management.entity.ProductEntity;

public interface IProductRepository extends GenericRepository<ProductEntity> {
	int add(ProductEntity productEntity);
	void update(ProductEntity productEntity);
	void delete(int id);
	ProductEntity findOne(int id);
	List<ProductEntity> findAll();
	List<ProductEntity> findByStoremachineid(int storemachineId);
	ProductEntity findMinByStoremachine(int id);
	ProductEntity findOneByIdAndStoremachineid(int productId, int storeMachineId);
}
