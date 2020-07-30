package atm.repository;

import java.util.List;

import atm.entity.Account;

public interface AccountRepository {
	
	int login(String username, String password);
	
	int create(Account acc);
	
	int update(Account acc);
	
	int delete(int id);
	
	List<Account> findAll();
	
	Account findById(int id);
	
	Account findByUser(String user);
}
