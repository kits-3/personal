package machinevending;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	static int money = 0;
	static boolean checkBuyMore = false;
	static Scanner sc = new Scanner(System.in);
	static List<Product> list;
	static List<Product> listProduct = new ArrayList<Product>();
	static final int MIN_COST = 100;

	public static void main(String[] args) {
		boolean checkLoop = false;
		String question;
		
		
		selectMachine(inputSelectMachine());
		
		System.out.println("Input your money please....");
		money = sc.nextInt();
		
		while (true) {
			while (money < MIN_COST || checkLoop == true && money < MIN_COST || checkBuyMore == true) {
				checkLoop = false;
				question = "Your money not enough! Do you want to add your money(y) or get your money current(n)?";
				if (askReturnMoney(question, MIN_COST)) {
					break;
				}
				checkBuyMore = false;
			}
			if (money >= MIN_COST && checkLoop == true) {
				question = "Do you want to buy more (y or n)?";
				if (askReturnMoney(question, MIN_COST)) {
					break;
				}
			}
			if (money == 0) {
				System.out.println("Thank you !");
				break;
			}
			System.out.println("Select you want to drink");
			
			int[] productCost = new int[list.size() + 1];
			
			int i = 1;
			for (Product items: list) {
				System.out.println(i + ". " + items.getName() + " " + items.getCost());
				productCost[i++] = items.getCost();
			}
			
			int select;
			Product product = null;
			while (true) {
				System.out.print("Your select: ");
				select = sc.nextInt();
				if (select > 0 || select <= list.size()) {
					if(list.get(select-1) instanceof Candy) {
						product = new Candy();
						product = list.get(select-1);
					}else if(list.get(select-1) instanceof Noodle) {
						product = new Noodle();
						product = list.get(select-1);
					}else if(list.get(select-1) instanceof Drink) {
						product = new Drink();
						product = list.get(select-1);
					}
//					Check count product to announce
					if(product.getCount() == 0) {
						if(product instanceof Candy) {
							((Candy) product).count();
						}else if(product instanceof Noodle) {
							((Noodle) product).count();
						}else if(product instanceof Drink) {
							((Drink) product).count();
						}
					}
					break;	
				}else {
					System.out.println("Your select not found! please select again");
				}
			}
			
			if(product.getCount() != 0) {
				selectProduct(productCost[select], product);
			}
			
			checkLoop = true;
		}
		sc.close();
	}

	public static boolean askReturnMoney(String question, int minCost) {
		while(true) {
			try {
				System.out.println("Your money current: " + money);
				System.out.println(question);
				String answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					money = 0;
					if(listProduct != null) {
						getReceipt(listProduct);
					}
					System.out.println("Your money is back");
					return true;
				} else if (answer.equalsIgnoreCase("y")) {
					if (money < minCost || checkBuyMore == true) {
						System.out.print("You want to add: ");
						int extraMoney = sc.nextInt();
						money += extraMoney;
						System.out.println("Your money current: " + money);
					} else {
						
					}
				}else {
					throw new Exception("Your answer is wrong !");
				}
				break;
			}catch (Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		return false;
	}

	public static void selectProduct(int productCost, Product product) {
		checkBuyMore = true;
		while(checkBuyMore) {
			if (money >= productCost) {
				money -= productCost;
				ThreadRun tr = new ThreadRun();
				Thread thread = new Thread(tr);
				thread.start();
				listProduct.add(product);
				product.setCount(product.getCount()-1);
				checkBuyMore = false;
			} else {
				checkBuyMore = true;
				String s = "Your money not enough to buy this! Do you want to add your money(y) or get your money current(n)?";
				if(askReturnMoney(s, MIN_COST)) break;
			}
		}
	}
	
	public static void selectMachine(int machine) {
		list = new ArrayList<Product>();
		switch (machine) {
		case 1:
			list.add(new Drink(100, "coke",3));
			list.add(new Drink(140, "pepsi",3));
			list.add(new Drink(100, "orange",3));
			break;
		case 2:
			list.add(new Noodle(100, "Gấu đỏ",3));
			list.add(new Noodle(160, "Lẩu thái",3));
			list.add(new Noodle(180, "Hảo Hảo",3));
			break;
		case 3:
			list.add(new Candy(100, "coffe",3));
			list.add(new Candy(120, "mentos",3));
			list.add(new Candy(130, "chocolate",3));
			break;
		default:
			break;
		}
	}
	
	public static void getReceipt(List<Product> list) {
		while(true) {
			try {
				System.out.println("Do you want get your receipt(y or n)?");
				String answer = sc.next();
				if(answer.equals("y")) {
					ExportReceipt receitp = new ExportReceipt(listProduct);
					receitp.createReceipt();
					receitp.exportConsole();
				}else if(answer.equals("n")) {
					
				}else {
					throw new Exception("Your answer is wrong !!");
				}
				break;
			}catch (Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
	}
	
	public static int inputSelectMachine() {
		int machine;
		while(true) {
			System.out.println("1. Drink Machine");
			System.out.println("2. Noodle Machine");
			System.out.println("3. Candy Machine");
			System.out.println("Select machine: ");
			try {
				machine = sc.nextInt();
				if(machine > 3 || machine < 1) {
					throw new Exception("Your answer is wrong !!");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return machine;
	}
}
