package atm.repository;

import java.util.ArrayList;
import java.util.List;

import atm.entity.History;

public interface HistoryRepository {
	
	int create(int id, int type, double money, int transfer_id, int status);
	
	List<History> history();
	
	List<History> findAll();
	List<History> findWithraw();
	List<History> findDeposit();
	List<History> findTransfer();
	List<History> findById(int id);
	
	ArrayList<List> banking();
	
}
