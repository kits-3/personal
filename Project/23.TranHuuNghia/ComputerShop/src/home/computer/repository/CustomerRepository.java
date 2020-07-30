package home.computer.repository;

import java.util.List;

import home.computer.entity.CustomerEntity;

public interface CustomerRepository {
	List<CustomerEntity> findALL();
	void UpdateMoney(String idUser, int money);
	int SelectMoney(String idUser);
	void insert_id_user(String user);

}
