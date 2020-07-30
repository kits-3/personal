package project.management.service.impl;

import java.util.List;

import project.management.entity.ProductEntity;
import project.management.repository.IProductRepository;
import project.management.repository.impl.ProductRepository;
import project.management.service.IProductService;

public class ProductService implements IProductService {
	IProductRepository productRepository = new ProductRepository();

	@Override
	public ProductEntity addProduct(ProductEntity productEntity) {
		int newId = productRepository.add(productEntity);
		return productRepository.findOne(newId);
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		productRepository.update(productEntity);
		return productRepository.findOne(productEntity.getId());

	}

	@Override
	public void deleteProduct(int id) {
		productRepository.delete(id);

	}

	@Override
	public List<ProductEntity> findAll() {
		return productRepository.findAll();
		
	}

	@Override
	public ProductEntity findOneById(int id) {
		return productRepository.findOne(id);
	}

}
