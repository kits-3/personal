package shoeshop.repository;

import java.util.List;

import shoeshop.entity.ProductEntity;

public interface ProductRepository {
	List<ProductEntity> findProduct();
	List<ProductEntity> findByNameM(String name);
	ProductEntity findById(int id);
	ProductEntity findByName(String name);
	public void addProduct(ProductEntity pe);
	public void showProduct(List<ProductEntity> listEntity);
	public void showProductU(List<ProductEntity> listEntity);
	public void deleteProduct(int id);
	public void updateProduct(ProductEntity pe);
	public int getMaxItem();
}
