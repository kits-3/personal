package atm.service;

public interface PanelService {
	
	int getMenu();
	boolean getMenuLogin();
	boolean getMenuAdmin();
	boolean getMenuAccount();
	boolean getMenuHistory();
	
	boolean history();
	
	int create();
	int update();
	int lock();
	
	int findAll();
	int findWithraw();
	int findDeposit();
	int findTransfer();
	int findById();
	
	boolean banking();
	
	
}
