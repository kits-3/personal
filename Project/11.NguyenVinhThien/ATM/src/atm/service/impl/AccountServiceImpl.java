package atm.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import atm.entity.Account;
import atm.entity.Session;
import atm.repository.impl.AccountImpl;
import atm.repository.impl.HistoryImpl;
import atm.service.AccountService;

public class AccountServiceImpl implements AccountService{
	
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
			AccountImpl login = new AccountImpl();
			Account acc = login.findByUser(user);
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

	@Override
	public int getMenu() {
		int n = 0;
		while(n < 1 || n > 6) {
			try {
				System.out.println("1. Check money");
				System.out.println("2. Change password");
				System.out.println("3. Withdraw");
				System.out.println("4. Deposit");
				System.out.println("5. Transfer");
				System.out.println("6. Exit");
				System.out.print("Select: ");
				n = Integer.valueOf(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		return n;
	}

	@Override
	public boolean check(int id) {
		
		boolean status = true;
		AccountImpl acc = new AccountImpl();
		Account account = acc.findById(id);
		
		System.out.println("------------------------------");
		System.out.printf("%-15s %s\n", "ID", account.getId());
		System.out.printf("%-15s %s\n", "Name", account.getName());
		System.out.printf("%-15s $%s\n", "Bank Account", String.format("%,.2f", account.getMoney()));
		
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Exit");
			
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = true;
				cstatus = false;
			} else if(ncheck.equals("2")) {
				status = false;
				cstatus = false;
			}
		}
		
		return status;
	}

	@Override
	public boolean change(int id) {
		boolean status = true;
		
		boolean check = true;
		System.out.println("------------------------------");
		while(check) {
			System.out.println("Old password (Press 0 to cancel): ");
			String opass = scanner.nextLine();
			if(opass.equalsIgnoreCase("0")) {
				break;
			}
			AccountImpl findAcc = new AccountImpl();
			Account acc = findAcc.findById(id);
			if(opass.equalsIgnoreCase(acc.getPassword()))
			{
				System.out.println("New password (Press 0 to cancel): ");
				String npass = scanner.nextLine();
				if(npass.equalsIgnoreCase("0") == false) {
					acc.setPassword(npass);
					AccountImpl accimpl = new AccountImpl();
					int stt = accimpl.update(acc);
					if(stt != 0) {
						HistoryImpl his = new HistoryImpl();
						his.create(acc.getId(), 4, 0, 0, 1);
						System.out.println("Change password success!");
						check = false;
					}
				} else {
					break;
				}
			}
		}
		
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Exit");
			
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = true;
				cstatus = false;
			} else if(ncheck.equals("2")) {
				status = false;
				cstatus = false;
			}
		}
		
		return status;
	}

	@Override
	public boolean withraw(int id2) {
		
		boolean status = true;
		AccountImpl f = new AccountImpl();
		Session sess = new Session();
		int id = id2;
		double min = sess.getMin();
		double withdraw = sess.getWithdraw();
		double min_withdraw = sess.getMinWithdraw();
		boolean check = true;
		
		while(check) {
			Account acc = f.findById(id);
			System.out.println("------------------------------");
			System.out.printf("%s $%s\n", "Bank Account", String.format("%,.2f", acc.getMoney()));
			System.out.println("Input money (Press 0 to cancel)");
			double money = Double.valueOf(scanner.nextLine());
			
			if(money == 0)
				return status;
			if(((money) > (acc.getMoney() - min - withdraw)) || money < min_withdraw) {
				System.out.println("Error: (Input min = $" + sess.getMinWithdraw() + " and input max = $" + String.format("%,.2f", (acc.getMoney() - min - withdraw)) + ")");
			} else {				
				acc.setMoney(acc.getMoney() - money - withdraw);
				int checkstt = f.update(acc);
				sess.updateWithdraw(money);
				HistoryImpl his = new HistoryImpl();
				his.create(acc.getId(), 1, money, 0, 1);
				if(checkstt != 0) {
					Invoice invoice = new Invoice();
					boolean inv = invoice.getMenu();
					if(inv) {
						Session s = new Session();
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						
						String bill = "";
						bill += "Name: \t\t" + Session.name + "\n";
						bill += "Withdraw: \t-$" + money + "\n";
						bill += "Charge: \t-$" + s.getWithdraw() + "\n";
						bill += "Money: \t\t$" + acc.getMoney() + "\n";
						bill += "Date: \t\t" + dtf.format(now);
						invoice.print(bill);
					}
					
					Wait wait = new Wait();
					wait.start();
					System.out.println("Withdraw success!");
					Account acc2 = f.findById(id);
					System.out.println("Account money: $" + String.format("%,.2f", acc2.getMoney()));
				}
			}
			
			
			// MENU
			boolean cstatus = true;
			while(cstatus) {
				System.out.println("------------------------------");
				System.out.println("1. Continue");
				System.out.println("2. Back");
				System.out.println("3. Exit");
				
				String ncheck = scanner.nextLine();
				if(ncheck.equals("1")) {
					status = true;
					cstatus = false;
					check = true;
				} else if(ncheck.equals("2")) {
					status = true;
					cstatus = false;
					check = false;
				} else if(ncheck.equals("3")) {
					status = false;
					cstatus = false;
					check = false;
				} 
			}
		}
		return status;
	}

	@Override
	public boolean deposit(int id) {
		
		boolean status = true;
		AccountImpl f = new AccountImpl();
		Account acc = f.findById(id);
		int money = 0;
		
		System.out.println("------------------------------");
		System.out.println("Account Money: $" + acc.getMoney());
		
		while(money <= 0) {
			try {
				System.out.println("Input money (Press 0 to cancel)");
				money = Integer.valueOf(scanner.nextLine());
				if(money == 0)
					break;
				
				acc.setMoney(acc.getMoney() + money);
				int cupdate = f.update(acc);
				if(cupdate != 0) {
					Session sess = new Session();
					sess.updateDeposit(money);
					Invoice invoice = new Invoice();
					
					//INSERT HISTORY
					HistoryImpl his = new HistoryImpl();
					his.create(acc.getId(), 3, money, 0, 1);
					
					boolean inv = invoice.getMenu();
					if(inv) {
						DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						LocalDateTime now = LocalDateTime.now();
						
						String bill = "";
						bill += "Name: \t\t" + Session.name + "\n";
						bill += "Deposit: \t+$" + money + "\n";
						bill += "Money: \t\t$" + acc.getMoney() + "\n";
						bill += "Date: \t\t" + dtf.format(now);
						invoice.print(bill);
					}
					
					Wait wait = new Wait();
					wait.start();
					System.out.println("Withdraw success!");
				}
				
				
			} catch (NumberFormatException e) {
				System.out.println("Error: Input number!");
			}
		}
		
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Exit");
			
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = true;
				cstatus = false;
			} else if(ncheck.equals("2")) {
				status = false;
				cstatus = false;
			}
		}
		
		return status;
	}

	@Override
	public boolean transfer(int id) {
		boolean status = true;
		AccountImpl f = new AccountImpl();
		Account acc = f.findById(id);
		Session sess = new Session();
		double min = sess.getMin();
		double transfer = sess.getTransfer();
		double min_withdraw = sess.getMinWithdraw();
		
		
		Account idtrans = null;
		
		System.out.println("------------------------------");
		System.out.println("Account Money: $" + acc.getMoney());
		boolean checkid = true;
		while(checkid) {
			double money = 0;
			int tid = 0;
			while(tid <= 0) {
				try {
					System.out.println("Input ID: (Press 0 to cancel)");
					tid = Integer.valueOf(scanner.nextLine());
					if(tid == 0) {
						checkid = false; 
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println("Error: Input number!");
				}
			}
			AccountImpl cid = new AccountImpl();
			idtrans = cid.findById(tid); 
			if(idtrans.getId() == 0) {
				if(tid != 0)
					System.out.println("ID not found!");
			}else if(idtrans.getId() != Session.id) {
				System.out.println("------------------------------");
				System.out.println("ID \t\t" + idtrans.getId());
				System.out.println("Account \t" + idtrans.getName());
				System.out.println("------------------------------");
				while(money <= 0) {
					try {
						//Scanner scan2 = new Scanner(System.in);
						System.out.println("Input money (Press 0 to cancel)");
						money = Double.valueOf(scanner.nextLine());
						if(money == 0) {
							checkid = false;
							break;
						}
						if(money == 0) {
							break;
						}else if(money < min_withdraw) {
							System.out.println("Error: Min " + min_withdraw + "$!");
						} else if(money > (acc.getMoney() - min - transfer)) {
							System.out.println("Error: (Input min = $" + sess.getMinWithdraw() + " and input max = $" + String.format("%,.2f", (acc.getMoney() - min - transfer)) + ")");
						} else {
							AccountImpl f2 = new AccountImpl();
							Account acc2 = f2.findById(tid);
							acc.setMoney(acc.getMoney() - money - transfer);
							acc2.setMoney(acc2.getMoney() + money);
							f2.update(acc);
							f2.update(acc2);
							
							//INSERT HISTORY
							HistoryImpl his = new HistoryImpl();
							his.create(acc.getId(), 2, money, acc2.getId(), 1);
							
							Invoice invoice = new Invoice();
							boolean inv = invoice.getMenu();
							if(inv) {
								DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
								LocalDateTime now = LocalDateTime.now();
								
								String bill = "";
								bill += "Name: \t\t" + Session.name + "\n";
								bill += "Transfer: \t-$" + money + "\n";		
								bill += "Money: \t\t$" + acc.getMoney() + "\n";
								bill += "Transfer ID: \t" + acc2.getId() + "\n";
								bill += "Date: \t\t" + dtf.format(now);
								invoice.print(bill);
							}
							
							Wait wait = new Wait();
							wait.start();
							System.out.println("Transfer success!");
							
							checkid = false;
						}
						
					} catch (NumberFormatException e) {
						System.out.println("Error: Input number!");
					}
				}
			}else if(idtrans.getId() == Session.id) {
				System.out.println("Can't transfer to myself!");
				money = 0;
			}
		}
		
		boolean cstatus = true;
		while(cstatus) {
			System.out.println("------------------------------");
			System.out.println("1. Back");
			System.out.println("2. Exit");
			
			String ncheck = scanner.nextLine();
			if(ncheck.equals("1")) {
				status = true;
				cstatus = false;
			} else if(ncheck.equals("2")) {
				status = false;
				cstatus = false;
			}
		}
		
		return status;
	}

}
