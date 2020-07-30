package project.management.repository.impl;

import java.util.List;

import project.management.entity.ProductEntity;
import project.management.mapper.ProductMapper;
import project.management.repository.IProductRepository;

public class ProductRepository extends AbstrachRepository<ProductEntity> implements IProductRepository {
	
	@Override
	public int add(ProductEntity productEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO product ");
		sql.append(" (name, price, total, storemachineid)");
		sql.append(" VALUES(?, ?, ?, ?)");
		return insert(sql.toString(), productEntity.getName(), productEntity.getPrice(), productEntity.getTotal(), productEntity.getStoreMachineId());
	}

	@Override
	public void update(ProductEntity productEntity) {
		StringBuilder sql = new StringBuilder("UPDATE product ");
		sql.append(" SET name = ?, price = ?, total = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), productEntity.getName(), productEntity.getPrice(), productEntity.getTotal());
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";
		update(sql, id);	
	}

	@Override
	public ProductEntity findOne(int id) {
		String sql = "SELECT * FROM  product where id = ?";
		List<ProductEntity>  productEntity = query(sql, new ProductMapper(), id);
		return productEntity.isEmpty() ? null : productEntity.get(0);
	}

	@Override
	public List<ProductEntity> findAll() {
		String sql = "SELECT * FROM product";
		return query(sql, new ProductMapper());
	}

	@Override
	public List<ProductEntity> findByStoremachineid(int storemachineId) {
		String sql = "SELECT * FROM product WHERE storemachineid = ?";
		List<ProductEntity>  productEntity = query(sql, new ProductMapper(), storemachineId);
		return productEntity.isEmpty() ? null : productEntity;
	}

	@Override
	public ProductEntity findMinByStoremachine(int id) {
		String sql = "SELECT * FROM product WHERE price = (SELECT MIN(price) FROM product WHERE storemachineid = ?)";
		return query(sql, new ProductMapper(), id).get(0);
	}

	

}
