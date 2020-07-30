package Admin;

import java.util.List;

import AdminEntity.ProductAdmin;

public interface ProductManageDao {
	
	List<ProductAdmin> findAll();
	
	void add(ProductAdmin pro);
	
//	void addCateId(int id);
//	void addName(String name);
//	void addPrice(int price);
//	void addDetail(String detail);
	
	void delete(int id);
	
	void update(ProductAdmin dto);
	
	void selectBill(ProductAdmin dto);

}
