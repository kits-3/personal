package atm.service.impl;

import java.util.List;
import java.util.Scanner;

import atm.entity.User;
import atm.repository.impl.UserImpl;
import atm.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	Scanner scanner = new Scanner(System.in);

	@Override
	public int getMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create() {
		
		int status = 1;
		while(status == 1) {
			System.out.println("------------------------------");
			System.out.println("Username (Press 0 to cancel)");
			String username = scanner.nextLine();
			
			UserImpl f = new UserImpl();
			User cadd = new User();
			cadd = f.findByUser(username);
			
			if(cadd.getUsername() == null && username.equals("0") == false) {
				System.out.println("Name");
				String name = scanner.nextLine();
				System.out.println("Password");
				String password = scanner.nextLine();
				
				//ADD DATABASE
				User user = new User();
				user.setUsername(username);
				user.setName(name);
				user.setPassword(password);
				
				UserImpl add = new UserImpl();
				
				int i = add.create(user);
				if(i != 0) {
					System.out.println("------------------------------");
					System.out.println("Create user success!");
					cadd = f.findByUser(username);
					System.out.printf("%-15s %s\n", "ID", cadd.getId());
					System.out.printf("%-15s %s\n", "Name", cadd.getName());
					System.out.printf("%-15s %s\n", "Username", cadd.getUsername());
					System.out.printf("%-15s %s\n", "Password", cadd.getPassword());
					System.out.printf("%-15s %s\n", "Status", cadd.getStatus() == 1 ? "Active" : "Lock");
				}
			} else if(cadd.getUsername() != null) {
				System.out.println("User already exists!");
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
			String password = "";
			System.out.println("Input username");
			String id = scanner.nextLine();
			
			UserImpl f = new UserImpl();
			User acc = f.findByUser(id);
			
			if(acc.getName() == null || acc.getId() == 1) {
				if(id.equals("0") == false && acc.getId() != 1)
					System.out.println("User not found!");
				if(acc.getId() == 1)
					System.out.println("Not edit user admin!");
			} else {
				System.out.println("------------------------------");
				System.out.println("Name: " + acc.getName() + " (Press 0 to skip)");
				name = scanner.nextLine();
				System.out.println("Password: (Press 0 to skip)");
				password = scanner.nextLine();
				
				if(name.equalsIgnoreCase("0") == false)
					acc.setName(name);
				if(password.equalsIgnoreCase("0") == false)
					acc.setPassword(password);
				
				if(f.update(acc) != 0) {
					System.out.println("------------------------------");
					System.out.println("Update account success!");
					System.out.printf("%-15s %s\n", "ID", acc.getId());
					System.out.printf("%-15s %s\n", "Name", acc.getName());
					System.out.printf("%-15s %s\n", "Username", acc.getUsername());
					System.out.printf("%-15s %s\n", "Password", acc.getPassword());
					System.out.printf("%-15s %s\n", "Status", acc.getStatus() == 1 ? "Active" : "Lock");
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
	public int delete() {
		int status = 1;
		while(status == 1) {
			
			System.out.println("Input username");
			String id = scanner.nextLine();
			
			UserImpl f = new UserImpl();
			User acc = f.findByUser(id);
			
			if(acc.getName() == null || acc.getId() == 1) {
				if(id.equals("0") == false && acc.getId() != 1)
					System.out.println("User not found!");
				if(acc.getId() == 1)
					System.out.println("Not delete user admin!");
			} else {
					System.out.println("------------------------------");
					System.out.printf("%-15s %s\n", "Name", acc.getName());
					System.out.printf("%-15s %s\n", "Username", acc.getUsername());
					System.out.printf("%-15s %s\n", "Status", acc.getStatus() == 1 ? "Active" : "Lock");
					String d = "";
					while(d == "" || d.equals("y") == false && d.equals("n") == false) {
						System.out.println("Delete? (y or n)");
						d = scanner.nextLine();
						if(d.equals("y")) {
							int t = f.delete(id);
							if(t != 0)
								System.out.println("Delete success!");
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
	public int block() {
		int status = 1;
		while(status == 1) {
			System.out.println("Input username (Press 0 to cancel)");
			String id = scanner.nextLine();
			
			if(id.equals("admin")) {
				System.out.println("Not lock user admin!");
			} else {
				
				UserImpl f = new UserImpl();
				User acc = f.findByUser(id);
				
				if(acc.getId() != 0) {
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
							acc.setStatus((acc.getStatus() == 0 ? 1 : 0));
							if(f.update(acc) != 0)
								System.out.println((acc.getStatus() == 0 ? "Lock" : "Active") + " success!");
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

				}else if(acc.getId() == 0 && id.equals("0") == false){
					System.out.println("ID not found!");
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
	
	public boolean checkArr(List<Integer> list, int item) {
	    for (int s: list) {
	        if (s == item)
	            return true;
	    }
	    return false;
	}

	@Override
	public int setRole() {
		
		int status = 1;
		while(status == 1) {
			
			System.out.println("Input username");
			String id = scanner.nextLine();
			
			UserImpl f = new UserImpl();
			User acc = f.findByUser(id);
			
			if(acc.getName() == null || acc.getId() == 1) {
				if(id.equals("0") == false && acc.getId() != 1)
					System.out.println("User not found!");
				else if(acc.getId() == 1)
					System.out.println("Not set role admin!");
			} else {
				
				List<Integer> list = f.checkRole(acc.getId());
				String[] name = {"Admin panel","Account","Transaction history", "Banking"};
				String rname = "";
				if(list.size() == 0) {
					rname += "None";
				} else {
					for(int i = 0; i < list.size(); i++) {
						if(i != list.size() -1)
							rname += name[list.get(i) - 1] + ", ";
						else
							rname += name[list.get(i) - 1];
					}
				}
				
				System.out.println("------------------------------");
				System.out.printf("%-15s %s\n", "Name", acc.getName());
				System.out.printf("%-15s %s\n", "Username", acc.getUsername());
				System.out.printf("%-15s %s\n", "Role", rname);
				
				//CHECK SIZE NO ROLE
				
				
				if(list.size() == 4) {
					System.out.println("------------------------------");
					System.out.println("There is not role to add!");
				} else {
					boolean c = true;
					int select = 0;
					String po = "";
					while(select < 0 || c == true || select > (4 - list.size())) {
						int ii = 0;
						System.out.println("------------------------------");
						for(int i = 1; i <= 4; i++) {
							if(checkArr(list, i) == false) {
								System.out.println(ii+1 + ". " + name[i-1]);
								po += i;
								ii++;
							}
						}
						String[] arr = po.split("", -1);
						System.out.println("0. Cancel ");
						System.out.println("Select: ");
						try {
							select = Integer.valueOf(scanner.nextLine());
							if(select == 0)
								c = false;
							else {
								int i = f.setRole(acc.getId(), Integer.parseInt(arr[select-1]));
								if(i != 0)
									System.out.println("Add role " + name[(Integer.parseInt(arr[select-1])) - 1] + " success!");
								c = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Error: Input number!");
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
	public int setUnRole() {
		
		int status = 1;
		while(status == 1) {
			
			System.out.println("Input username");
			String id = scanner.nextLine();
			
			UserImpl f = new UserImpl();
			User acc = f.findByUser(id);
			
			if(acc.getName() == null || acc.getId() == 1) {
				if(id.equals("0") == false && acc.getId() != 1)
					System.out.println("User not found!");
				else if(acc.getId() == 1)
					System.out.println("Not delete role admin!");
			}else {
				
				List<Integer> list = f.checkRole(acc.getId());
				String[] name = {"Admin panel","Account","Transaction history", "Banking"};
				String rname = "";
				if(list.size() == 0) {
					rname += "None";
				} else {
					for(int i = 0; i < list.size(); i++) {
						if(i != list.size() -1)
							rname += name[list.get(i) - 1] + ", ";
						else
							rname += name[list.get(i) - 1];
					}
				}
				
				System.out.println("------------------------------");
				System.out.printf("%-15s %s\n", "Name", acc.getName());
				System.out.printf("%-15s %s\n", "Username", acc.getUsername());
				System.out.printf("%-15s %s\n", "Role", rname);
				
				//CHECK SIZE NO ROLE
				
				
				if(list.size() == 0) {
					System.out.println("------------------------------");
					System.out.println("There is not role to delete role!");
				} else {
					boolean c = true;
					int select = 0;
					String po = "";
					while(select < 0 || c == true || select > (4 - list.size())) {
						int ii = 0;
						System.out.println("------------------------------");
						for(int i = 1; i <= 4; i++) {
							if(checkArr(list, i) == true) {
								System.out.println(ii+1 + ". " + name[i-1]);
								po += i;
								ii++;
							}
						}
						String[] arr = po.split("", -1);
						System.out.println("0. Cancel ");
						System.out.println("Select: ");
						try {
							select = Integer.valueOf(scanner.nextLine());
							if(select == 0)
								c = false;
							else {
								int i = f.setUnRole(acc.getId(), Integer.parseInt(arr[select-1]));
								if(i != 0)
									System.out.println("Delete role " + name[(Integer.parseInt(arr[select-1])) - 1] + " success!");
								c = false;
							}
						} catch (NumberFormatException e) {
							System.out.println("Error: Input number!");
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
	
	
}
