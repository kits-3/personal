package repository;

import java.util.List;

import entity.Customer;

public interface CustomerRepository {
	List<Customer> findAll();
	List<Customer> findById(int id_customer);
	void update(Customer cus);
	void delete(int id_customer);
	void add(Customer cus);
	void updateMoney(Customer cus);
}
