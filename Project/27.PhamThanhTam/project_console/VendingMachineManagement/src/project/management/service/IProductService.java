package project.management.service;

import java.util.List;

import project.management.entity.ProductEntity;

public interface IProductService {
	ProductEntity addProduct(ProductEntity productEntity);
	ProductEntity updateProduct(ProductEntity productEntity);
	void deleteProduct(int id);
	List<ProductEntity> findAll();
	ProductEntity findOneById(int id);
	ProductEntity findOneByIdAndStoremachineid(int productId, int storeMachineId);
}
