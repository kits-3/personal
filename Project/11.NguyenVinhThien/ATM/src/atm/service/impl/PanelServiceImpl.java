package atm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import atm.entity.Account;
import atm.entity.History;
import atm.entity.User;
import atm.repository.impl.AccountImpl;
import atm.repository.impl.HistoryImpl;
import atm.repository.impl.UserImpl;
import atm.service.PanelService;

public class PanelServiceImpl implements PanelService  {
	
	Scanner scanner = new Scanner(System.in);

	@Override
	public boolean getMenuLogin() {
		boolean status = false;
		boolean check = true;
		while(check) {
			System.out.println("Username");
			String user = scanner.nextLine();
			System.out.println("Password");
			String pass = scanner.nextLine();
			UserImpl login = new UserImpl();
			User acc = login.findByUser(user);
			if(login.login(user, pass) != 0 && acc.getStatus() != 0) {
					status = true;
					check = false;
					System.out.println("Login success!");
			} else {
				if(login.login(user, pass) != 0 && acc.getStatus() == 0)
					System.out.println("Account is locked!");
				else
					System.out.println("Login failed!");
				
				boolean cstatus = true;
				while(cstatus) {
					System.out.println("------------------------------");
					System.out.println("1. Login");
					System.out.println("2. Exit");
					
					String ncheck = scanner.nextLine();
					if(ncheck.equals("1")) {
						check = true;
						cstatus = false;
					} else if(ncheck.equals("2")) {
						status = false;
						return status;
					}
				}
			}
		}
		return status;
	}
	
	public int getMenu2() {
		
		int n = 0;
		
		while(n < 1 || n > 4) {
			try {
				System.out.println("------------------------------");
				System.out.println("1. Account");
				System.out.println("2. Transaction history");
				System.out.println("3. Banking");
				System.out.println("4. Exit");
				System.out.print("Select: ");
				n = Integer.valueOf(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		return n;
	}
	
public int getMenu() {
		
		int n = 0;
		int status = 0;
		boolean check = true;
		UserImpl f = new UserImpl();
		
		List<Integer> list = new ArrayList<Integer>();
		list = f.checkRole(User.session_id);
		
		if(list.size() == 0) {
			System.out.println("------------------------------");
			System.out.println("Not have access");
			return 5;
		}
			
		
		while(check) {
			try {
				System.out.println("------------------------------");
				
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i) == 1)
					{
						System.out.println(i+1 +". Admin panel");
					}else if(list.get(i) == 2) {
						System.out.println(i+1 + ". Account");
					}else if(list.get(i) == 3) {
						System.out.println(i+1 + ". Transaction history");
					}else if(list.get(i) == 4) {
						System.out.println(i+1 + ". Banking");
					}
				}
				System.out.println(list.size()+1 + ". Exit");
				System.out.print("Select: ");
				n = Integer.valueOf(scanner.nextLine());
				
				for(int i = 0; i < list.size(); i++) {
					if(n == i+1) {
						status = list.get(i);
						return status;
					}
				}
				if(n == list.size()+1) {
					status = 5;
					return status;
				}
					
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		return status;
	}
	
	@Override
	public boolean getMenuAdmin() {
		
		AdminServiceImpl ad = new AdminServiceImpl();
		boolean status = true;
		int n = 0;
		int check = 2;
		
		while(n < 1 || n > 5 || check == 2 ) {
			try {
				
				System.out.println("------------------------------");
				System.out.println("1. Create user");
				System.out.println("2. Edit user");
				System.out.println("3. Delete user");
				System.out.println("4. Block / Unlock user");
				System.out.println("5. Set role user");
				System.out.println("6. Delete role user");
				System.out.println("7. Set banking");
				System.out.println("8. Cancel");
				System.out.println("9. Exit");
				System.out.println("Select: ");
				n = Integer.valueOf(scanner.nextLine());
				
				if(n == 1) {
					check = ad.create();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 2) {
					check = ad.update();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 3) {
					check = ad.delete();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 4) {
					check = ad.block();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 5) {
					check = ad.setRole();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 6) {
					check = ad.setUnRole();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 7) {
					check = ad.setATM();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 8) {
					status = true;
					return status;
				}else if(n == 9) {
					status = false;
					return status;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		
		return status;
	}

	@Override
	public boolean getMenuAccount() {
		boolean status = true;
		int n = 0;
		int check = 2;
		
		while(n < 1 || n > 5 || check == 2 ) {
			try {				
				System.out.println("------------------------------");
				System.out.println("1. Create Account");
				System.out.println("2. Edit Account");
				System.out.println("3. Block / Unlock Account");
				System.out.println("4. Cancel");
				System.out.println("5. Exit");
				System.out.print("Select: ");
				n = Integer.valueOf(scanner.nextLine());
				
				if(n == 1) {
					check = create();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 2) {
					check = update();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 3) {
					check = lock();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 4) {
					status = true;
					return status;
				}else if(n == 5) {
					status = false;
					return status;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		return status;
	}

	@Override
	public boolean getMenuHistory() {
		boolean status = true;
		int n = 0;
		int check = 2;
		
		while(n < 1 || n > 7 || check == 2 ) {
			try {
				System.out.println("------------------------------");
				System.out.println("1. Transaction history");
				System.out.println("2. Withdraw history");
				System.out.println("3. Deposit history");
				System.out.println("4. Transfer history");
				System.out.println("5. Find by ID");
				System.out.println("6. Cancel");
				System.out.println("7. Exit");
				System.out.print("Select: ");
				n = Integer.valueOf(scanner.nextLine());
				
				if(n == 1) {
					check = findAll();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 2) {
					check = findWithraw();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 3) {
					check = findDeposit();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 4) {
					check = findTransfer();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 5) {
					check = findById();
					if(check == 3) {
						status = true;
						break;
					}else if(check == 4) {
						status = false;
						break;
					}
					status = true;
				}else if(n == 6) {
					status = true;
					return status;
				}else if(n == 7) {
					status = false;
					return status;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		
		return status;
	}
	
	@Override
	public boolean history() {
		boolean status = true;
		HistoryImpl his = new HistoryImpl();
		List<History> list = new ArrayList<History>();
		list = his.history();
		int i = 1;
			System.out.printf("%-5s %-5s %-20s %-16s %-10s %-27s %-27s %s\n", "STT", "ID", "Account ID", "Type", "Money", "Transfer ID", "Date", "Status");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		for(History item : list) {
			System.out.printf("%-5s %-5s    %-13s %-20s %-14s %-15s %-35s %s\n", i, item.getId(), item.getAccount_id(), item.get_NameType(), item.getMoney() == 0 ? "" : "$" + item.getMoney(), item.getTransfer_id() == 0 ? "" : item.getTransfer_id(), item.getCreate_at(), item.getStatus() == 1 ? "Success" : "Failed");
			i++;			
		}
		return status;
	}
	
	public String randomUser() {
		boolean check = true;
		Account acc = new Account();
		String user = "ID";
		
		while(check) {
			for(int i = 0; i < 8; i++) {
				Random rd = new Random();
				int type = rd.nextInt(2);
				if(type == 0) {
					user += rd.nextInt(10);
				}else {
					user += (char) (65 + rd.nextInt(25));
				}
			}
			
			AccountImpl f = new AccountImpl();
			acc = f.findByUser(user);
			if(acc.getId() == 0) {
				check = false;
			}
		}
		
		return user;
	}

	public String randomPass() {
		String pass = "";
		for(int i = 0; i < 6; i++) {
			Random rd = new Random();
			int type = rd.nextInt(2);
			if(type == 0) {
				pass += rd.nextInt(10);
			}else {
				pass += (char) (97 + rd.nextInt(25));
			}
		}
		return pass;
	}
	
	@Override
	public int create() {
		
		int status = 1;
		while(status == 1) {
			System.out.println("------------------------------");
			System.out.println("Name (Press 0 to cancel)");
			String name = scanner.nextLine();
			
			if(name.equals("0") == false)
			{
				System.out.println("ID Card (Press 0 to cancel)");
				String card = scanner.nextLine();
				if(card.equals("0") == false) {
					System.out.println("Contact (Press 0 to cancel)");
					String contact = scanner.nextLine();
					if(contact.equals("0") == false) {
						String user = randomUser();
						String pass = randomPass();
						
						//ADD DATABASE
						Account acc = new Account();
						acc.setName(name);;
						acc.setUsername(user);
						acc.setPassword(pass);
						acc.setMoney(5);
						acc.setId_card(card);
						acc.setContact(contact);
						AccountImpl add = new AccountImpl();
						int i = add.create(acc);
						if(i != 0) {
							System.out.println("------------------------------");
							System.out.println("Create account success!");
							System.out.printf("%-15s %s\n", "Name", name);
							System.out.printf("%-15s %s\n", "Username", user);
							System.out.printf("%-15s %s\n", "Pass", pass);
							System.out.printf("%-15s %s\n", "ID Card", card);
							System.out.printf("%-15s %s\n", "Contact", contact);
						}
					}
				}
				
			}
			
			
			//MENU
			boolean cstatus = true;
			while(cstatus) {
				System.out.println("------------------------------");
				System.out.println("1. Continue");
				System.out.println("2. Back");
				System.out.println("3. Home");
				System.out.println("4. Exit");
				String ncheck = scanner.nextLine();
				if(ncheck.equals("1")) {
					status = 1;
					cstatus = false;
				}else if(ncheck.equals("2")) {
					status = 2;
					break;
				}else if(ncheck.equals("3")) {
					status = 3;
					break;
				}else if(ncheck.equals("4")) {
					status = 4;
					break;
				}
			}
		}
		return status;
	}

	@Override
	public int update() {
		int status = 1;
		while(status == 1) {
			
			String name = "";
			String card = "";
			String contact = "";
			System.out.println("Input ID");
			int id = Integer.valueOf(scanner.nextLine());			
			AccountImpl f = new AccountImpl();
			Account acc = f.findById(id);
			
			if(acc.getId() == 0) {
				System.out.println("ID not found!");
			} else {
				System.out.println("------------------------------");
				System.out.println("Name: " + acc.getName() + " (Press 0 to skip)");
				name = scanner.nextLine();
				System.out.println("ID Card: " + acc.getId_card() + " (Press 0 to skip)");
				card = scanner.nextLine();
				System.out.println("Contact: " + acc.getContact() + " (Press 0 to skip)");
				contact = scanner.nextLine();
				
				if(name.equalsIgnoreCase("0") == false)
					acc.setName(name);
				if(card.equalsIgnoreCase("0") == false)
					acc.setId_card(card);
				if(contact.equalsIgnoreCase("0") == false)
					acc.setContact(contact);
				if(f.update(acc) != 0) {
					System.out.println("------------------------------");
					System.out.println("Update account success!");
					System.out.printf("%-15s %s\n", "Name", acc.getName());
					System.out.printf("%-15s %s\n", "Username", acc.getUsername());
					System.out.printf("%-15s %s\n", "Password", "******");
					System.out.printf("%-15s %s\n", "ID Card", acc.getId_card());
					System.out.printf("%-15s %s\n", "Contact", acc.getContact());
				}
			}
			
			//MENU
			boolean cstatus = true;
			while(cstatus) {
				System.out.println("------------------------------");
				System.out.println("1. Continue");
				System.out.println("2. Back");
				System.out.println("3. Home");
				System.out.println("4. Exit");
				String ncheck = scanner.nextLine();
				if(ncheck.equals("1")) {
					status = 1;
					cstatus = false;
				}else if(ncheck.equals("2")) {
					status = 2;
					break;
				}else if(ncheck.equals("3")) {
					status = 3;
					break;
				}else if(ncheck.equals("4")) {
					status = 4;
					break;
				}
			}
		}
		return status;
	}
	
	@Override
	public int lock() {
		int status = 1;
		while(status == 1) {
			int id = 0;
			boolean checkNum = true; 
			while(checkNum) {
				try {
					System.out.println("Input ID (Press 0 to cancel)");
					id = Integer.valueOf(scanner.nextLine());
					checkNum = false;
				} catch (NumberFormatException e) {
					System.out.println("Error: Input number!");
				}
			}
			
			AccountImpl f = new AccountImpl();
			Account acc = f.findById(id);
			
			if(f.update(acc) != 0 && id != 0) {
				System.out.println("------------------------------");
				System.out.printf("%-15s %s\n", "Name", acc.getName());
				System.out.printf("%-15s %s\n", "Username", acc.getUsername());
				System.out.printf("%-15s %s\n", "Status", acc.getStatus() == 0 ? "Lock" : "Active");
				
				
				boolean cstatus = true;
				while(cstatus) {
					System.out.println("------------------------------");
					System.out.println("1. " + (acc.getStatus() == 0 ? "Acitve" : "Lock"));
					System.out.println("2. Back");
					System.out.println("3. Home");
					System.out.println("4. Exit");
					String ncheck = scanner.nextLine();
					if(ncheck.equals("1")) {
						String d = "";
						while(d == "" || d.equals("y") == false && d.equals("n") == false) {
							System.out.println("Delete? (y or n)");
							d = scanner.nextLine();
							if(d.equals("y")) {
								acc.setStatus((acc.getStatus() == 0 ? 1 : 0));
								if(f.update(acc) != 0)
									System.out.println((acc.getStatus() == 0 ? "Lock" : "Active") + " success!");
								cstatus = false;
							}
						}
					}else if(ncheck.equals("2")) {
						status = 2;
						return status;
					}else if(ncheck.equals("3")) {
						status = 3;
						return status;
					}else if(ncheck.equals("4")) {
						status = 4;
						return status;
					}
				}
			}else if(id != 0){
				System.out.println("ID not found!");
			}
			
			//MENU
			boolean cstatus = true;
			while(cstatus) {
				System.out.println("------------------------------");
				System.out.println("1. Continue");
				System.out.println("2. Back");
				System.out.println("3. Home");
				System.out.println("4. Exit");
				String ncheck = scanner.nextLine();
				if(ncheck.equals("1")) {
					status = 1;
					cstatus = false;
				}else if(ncheck.equals("2")) {
					status = 2;
					return status;
				}else if(ncheck.equals("3")) {
					status = 3;
					return status;
				}else if(ncheck.equals("4")) {
					status = 4;
					return status;
				}
			}
		}
		return status;
	}

	@Override
	public int findAll() {
		int status = 2;
		HistoryImpl his = new HistoryImpl();
		List<History> list = new ArrayList<History>();
		list = his.findAll();
		int i = 0;
		double money = 0;
		System.out.println("------------------------------");
		System.out.printf("%-5s %-5s %-20s %-16s %-10s %-27s %-27s %s\n", "STT", "ID", "Account ID", "Type", "Money", "Transfer ID", "Date", "Status");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		for(History item : list) {
			i++;
			money += item.getMoney();
			System.out.printf("%-5s %-5s    %-13s %-20s %-14s %-15s %-35s %s\n", i, item.getId(), item.getAccount_id(), item.get_NameType(), item.getMoney() == 0 ? "" : "$" + String.format("%,.2f", item.getMoney()), item.getTransfer_id() == 0 ? "" : item.getTransfer_id(), item.getCreate_at(), item.getStatus() == 1 ? "Success" : "Failed");
		}
		
		System.out.println("------------------------------");
		System.out.printf("%-10s %s\n", "Total:", i);
		System.out.printf("%-10s %s\n", "Money:", money);
		
		//MENU
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Home");
			System.out.println("3. Exit");
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = 2;
				cstatus = false;
			}else if(ncheck.equals("2")) {
				status = 3;
				return status;
			}else if(ncheck.equals("3")) {
				status = 4;
				return status;
			}
		}
		return status;
	}

	@Override
	public int findWithraw() {
		int status = 2;
		HistoryImpl his = new HistoryImpl();
		List<History> list = new ArrayList<History>();
		list = his.findWithraw();
		int i = 0;
		double money = 0;
		System.out.println("------------------------------");
			System.out.printf("%-5s %-5s %-20s %-16s %-20s %-26s %s\n", "STT", "ID", "Account ID", "Type", "Money", "Date", "Status");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for(History item : list) {
			i++;
			money += item.getMoney();
			System.out.printf("%-5s %-9s %-13s %-18s %-14s %-33s %s\n", i, item.getId(), item.getAccount_id(), item.get_NameType(), item.getMoney() == 0 ? "" : "$" + String.format("%,.2f", item.getMoney()), item.getCreate_at(), item.getStatus() == 1 ? "Success" : "Failed");
		}
		System.out.println("------------------------------");
		System.out.printf("%-10s %s\n", "Total:", i);
		System.out.printf("%-10s %s\n", "Money:", money);
		//MENU
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Home");
			System.out.println("3. Exit");
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = 2;
				cstatus = false;
			}else if(ncheck.equals("2")) {
				status = 3;
				return status;
			}else if(ncheck.equals("3")) {
				status = 4;
				return status;
			}
		}
		return status;
	}

	@Override
	public int findDeposit() {
		int status = 2;
		HistoryImpl his = new HistoryImpl();
		List<History> list = new ArrayList<History>();
		list = his.findDeposit();
		int i = 0;
		double money = 0;
		System.out.println("------------------------------");
		System.out.printf("%-5s %-7s %-20s %-19s %-26s %-28s %s\n", "STT", "ID", "Account ID", "Type", "Money", "Date", "Status");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		for(History item : list) {
			i++;
			System.out.printf("%-5s %-11s %-15s %-20s %-19s %-35s %s\n", i, item.getId(), item.getAccount_id(), item.get_NameType(), item.getMoney() == 0 ? "" : "$" + String.format("%,.2f", item.getMoney()), item.getCreate_at(), item.getStatus() == 1 ? "Success" : "Failed");
			money += item.getMoney();
		}
		System.out.println("------------------------------");
		System.out.printf("%-10s %s\n", "Total:", i);
		System.out.printf("%-10s %s\n", "Money:", money);
		//MENU
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Home");
			System.out.println("3. Exit");
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = 2;
				cstatus = false;
			}else if(ncheck.equals("2")) {
				status = 3;
				return status;
			}else if(ncheck.equals("3")) {
				status = 4;
				return status;
			}
		}
		return status;
	}

	@Override
	public int findTransfer() {
		int status = 2;
		HistoryImpl his = new HistoryImpl();
		List<History> list = new ArrayList<History>();
		list = his.findTransfer();
		int i = 0;
		double money = 0;
		System.out.println("------------------------------");
		System.out.printf("%-5s %-5s %-18s %-18s %-13s %-27s %-27s %s\n", "STT", "ID", "Account ID", "Type", "Money", "Transfer ID", "Date", "Status");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
		for(History item : list) {
			i++;
			money += item.getMoney();
			System.out.printf("%-5s %-5s    %-13s %-20s %-17s %-15s %-35s %s\n", i, item.getId(), item.getAccount_id(), item.get_NameType(), item.getMoney() == 0 ? "" : "$" + String.format("%,.2f", item.getMoney()), item.getTransfer_id() == 0 ? "" : item.getTransfer_id(), item.getCreate_at(), item.getStatus() == 1 ? "Success" : "Failed");
		}
		
		System.out.println("------------------------------");
		System.out.printf("%-10s %s\n", "Total:", i);
		System.out.printf("%-10s %s\n", "Money:", money);
		
		//MENU
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Home");
			System.out.println("3. Exit");
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = 2;
				cstatus = false;
			}else if(ncheck.equals("2")) {
				status = 3;
				return status;
			}else if(ncheck.equals("3")) {
				status = 4;
				return status;
			}
		}
		return status;
	}

	@Override
	public int findById() {
		
		int id = 0;
		boolean checkNum = true; 
		while(checkNum) {
			try {
				System.out.println("Input ID (Press 0 to cancel)");
				id = Integer.valueOf(scanner.nextLine());
				checkNum = false;
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		
		int status = 2;
		HistoryImpl his = new HistoryImpl();
		List<History> list = new ArrayList<History>();
		list = his.findById(id);
		if(list.size() == 0) {
			System.out.println("History not found!");
		}else if(id != 0) {
			int i = 0;
			double money = 0;
			System.out.println("------------------------------");
			System.out.printf("%-5s %-5s %-20s %-16s %-10s %-27s %-27s %s\n", "STT", "ID", "Account ID", "Type", "Money", "Transfer ID", "Date", "Status");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
			for(History item : list) {
				i++;
				money += item.getMoney();
				System.out.printf("%-5s %-5s    %-13s %-20s %-14s %-15s %-35s %s\n", i, item.getId(), item.getAccount_id(), item.get_NameType(), item.getMoney() == 0 ? "" : "$" + String.format("%,.2f", item.getMoney()), item.getTransfer_id() == 0 ? "" : item.getTransfer_id(), item.getCreate_at(), item.getStatus() == 1 ? "Success" : "Failed");
			}
			
			System.out.println("------------------------------");
			System.out.printf("%-10s %s\n", "Total:", i);
			System.out.printf("%-10s %s\n", "Money:", money);
		}
		
		//MENU
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Home");
			System.out.println("3. Exit");
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = 2;
				cstatus = false;
			}else if(ncheck.equals("2")) {
				status = 3;
				return status;
			}else if(ncheck.equals("3")) {
				status = 4;
				return status;
			}
		}
		
		return status;
	}

	@Override
	public boolean banking() {
		
		boolean status = true;
		HistoryImpl his = new HistoryImpl();
		his.findAll();
		
		System.out.println("------------------------------");
		System.out.println("Bank Money: $724,386,679.00");
		System.out.println("------------------------------");
		System.out.printf("%-11s %-18s %-25s %-27s %-27s %s\n", "Month", "Transaction", "Withdraw", "Transfer", "Deposit", "Analyse");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		
		ArrayList<List> list = new ArrayList<List>(); 
		list = his.banking();
		int maxwith = Integer.parseInt(list.get(list.size() - 1).get(1).toString());
		int maxtran = Integer.parseInt(list.get(list.size() - 1).get(2).toString());
		int maxde = Integer.parseInt(list.get(list.size() - 1).get(3).toString());
		int maxtrans = Integer.parseInt(list.get(list.size() - 1).get(4).toString());
		
		int i = 0;
		for(List<Integer> item : list) {
			i++;
			int per = (item.get(3).intValue() - item.get(1).intValue());
			String str = "";
			if(per < 0)
				str = String.valueOf(per).replace("-", "-$");
			else
				str = "+$" + String.valueOf(per);
			
			double pertrans = 0;
			if(maxtrans != 0)
				pertrans = ((float)item.get(4).intValue() - (float)maxtrans) / (float)maxtrans * 100;
			else
				pertrans = (float)item.get(4).intValue();
			
			double perwith = 0;
			if(maxwith != 0)
				perwith = ((float)item.get(1).intValue() - (float)maxwith) / (float)maxwith * 100;
			else
				perwith = (float)item.get(1).intValue();
			
			double pertran = 0;
			if(maxtran != 0)
				pertran = ((float)item.get(2).intValue() - (float)maxtran) / (float)maxtran * 100;
			else
				pertran = (float)item.get(2).intValue();
			
			double perde = 0;
			if(maxde != 0)
				perde = ((float)item.get(3).intValue() - (float)maxde) / (float)maxde * 100;
			else
				perde = (float)item.get(3).intValue();
			
			pertrans = (double)(Math.ceil(pertrans * 10) / 10);
			perwith = (double)(Math.ceil(perwith * 10) / 10);
			pertran = (double)(Math.ceil(pertran * 10) / 10);
			perde = (double)(Math.ceil(perde * 10) / 10);
			
			System.out.printf(" %-10s %-18s $%-24s $%-26s $%-25s %s\n",
					item.get(0).intValue(),
					item.get(4).intValue() + (i == list.size() ? " (100.0%)" : " (" + pertrans + "%)"),
					String.format("%,.2f", (double)item.get(1).intValue()) + (i == list.size() ? " (100.0%)" : " (" + perwith + "%)"),
					String.format("%,.2f", (double)item.get(2).intValue()) + (i == list.size() ? " (100.0%)" : " (" + pertran + "%)"),
					String.format("%,.2f", (double)item.get(3).intValue()) + (i == list.size() ? " (100.0%)" : " (" + perde + "%)"),
					str);
		}
		
		//MENU
				boolean cstatus = true;
				while(cstatus) {
					System.out.println("------------------------------");
					System.out.println("1. Back");
					System.out.println("2. Exit");
					String ncheck = scanner.nextLine();
					if(ncheck.equals("1")) {
						status = true;
						cstatus = false;
					}else if(ncheck.equals("2")) {
						status = false;
						return status;
					}
				}
		return status;
	}

}
