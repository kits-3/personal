package Dao;

import java.util.List;

import entity.Customer;

public interface CustomerDao {
	
	List<Customer> findAll();
//	void update(Customer dto);
//	void delete(int id);
//	void addId(int id);
	void add(Customer dto);
	void addName(String name);
	void addAddress(String address);
	void addPhone(String phone);
	void delete (int id);
	
}
