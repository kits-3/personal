package project.management.task;

import project.management.entity.ProductEntity;

public interface IProduct {
	void insertProduct(ProductEntity productEntity, ProductEntity productAlreadyInsertEntity);
	void updateProduct(ProductEntity productEntity);
	void deleteProduct();
	
}
