package adminDao;

import java.util.List;

import entity.Account;
import entity.Bill;

public interface BillDao {
	List<Bill> findAll();
}
