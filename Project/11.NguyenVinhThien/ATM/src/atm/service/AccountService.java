package atm.service;

public interface AccountService {
	boolean getMenuLogin();
	int getMenu();
	boolean check(int id);
	boolean change(int id);
	boolean withraw(int id);
	boolean deposit(int id);
	boolean transfer(int id);
}
