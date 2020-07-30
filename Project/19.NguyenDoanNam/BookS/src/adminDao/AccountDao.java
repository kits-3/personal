package adminDao;

import java.util.List;

import entity.Account;

public interface AccountDao {
	
	Account findById(Integer Id_role);

	List<Account> findAll();

	void add(Account account);

	void update(Account account);

	void delete(Integer Id_role);
}
