package dung.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dung.connect.Dao;
import dung.connect.LogIn;
import dung.dto.Info;
import dung.dto.Order;
import dung.dto.Product;
import dung.dto.User;

public class Person {
	static Dao dao = new Dao();
	static Scanner scan = new Scanner(System.in);
	String traLoi = null;
	Info userInfo = new Info();
	LogIn login = new LogIn();
	Order order = new Order();
	List<Product> ls = dao.findProduct();
	List<Order> lsOrder = new ArrayList<Order>();

	public void person(User user) {
		boolean choice = true;
		userInfo = dao.findInfo(user.getId());
		System.out.println("Well come "+user.getRole_name()+"!\n");
		dao.viewInfo(user.getId());
		System.out.println("_____________________________________________________________________________________________\n");
		while (choice) {
			System.out.print("1-Recharge\t");
			System.out.print("2-Order\t\t");
			System.out.print("3-View-order\t");
			System.out.print("4-Change-info\t");
			System.out.print("5-Change-password\t");
			System.out.println("6-Logout");
			System.out.print("\nInput choice: ");
			int intChoice = scan.nextInt();
			switch (intChoice) {
			case 1: {//recharge
				System.out.print("Input money: ");
				double money = scan.nextDouble();
				dao.addMoney(user, money);
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 2: {//order
				boolean checkOrder = true;
				do {
					try {
						System.out.println("Input order!");
						order = new Order();
						System.out.print("Input id product: ");
						int id_pro = scan.nextInt();
						System.out.print("Input quantity: ");
						int Qty = scan.nextInt();

						double mountOrder = ls.get(id_pro - 1).getPrice_out() * Qty;
						order.setUsers_id(user.getId());
						order.setPro_id(ls.get(id_pro - 1).getId());
						order.setQuantity(Qty);
						order.setMount(mountOrder);
						order.setInfo_id(userInfo.getId());
						order.setStatus_check("none-check");
						dao.addOrder(order);

						System.out.println("Add order ? (y/n?)");
						System.out.println("Answer: ");
						String addOr = scan.next();
						if (addOr.equalsIgnoreCase("n"))
							checkOrder = false;
						else {
							System.out.println("Input again!");
						}
					} catch (Exception e) {
						System.out.println("input error..rrrr...!!!");
						checkOrder = false;
					}
				} while (checkOrder);
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 3: {//view order
				boolean checkView = true;
				do {
					lsOrder = null;
					System.out.println("Your order:");
					lsOrder = dao.findOrder(user.getId());
					for (int j = 0; j < lsOrder.size(); j++) {
						System.out.println(lsOrder.get(j).toString());
					}
					System.out.println("Are You delete order? (y/n?)");
					System.out.print("Answer: ");
					String View = scan.next();
					if (View.equalsIgnoreCase("n"))
						checkView = false;
					else if (View.equalsIgnoreCase("y")) {
						System.out.print("Input idOrder delete: ");
						int del = scan.nextInt();
						for (int i = 0; i < lsOrder.size(); i++) {
							if (del == lsOrder.get(i).getId()) {
								dao.delOrder(del);
							} else {
								System.out.println("input error!!");
							}
						}
					} else {
						System.out.println("input error!!!\n input again");
						checkView = true;
					}
				} while (checkView);
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 4: {
				userInfo = dao.findInfo(user.getId());
				System.out.println("Your info:");
				System.out.print(userInfo.toString());
				System.out.println("Are you fix info? (y/n?)");
				String fixInfo = scan.next();
				if (fixInfo.equalsIgnoreCase("y")) {
					dao.changeInfo(user);
					dao.viewInfo(user.getId());
				}
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 5: {//change password
				boolean checkPass = true;
				do {
				System.out.print("input old password:");
				String oldPass = scan.next();
				if (oldPass.equalsIgnoreCase(user.getPassword())) {
					dao.changePass(user);
					checkPass = false;
				} else System.out.println("change password false!");
				}while(checkPass);
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 6: {
				choice = false;
				break;
			}
			default:
				choice = false;
			}
		}
		System.out.println("_____________________________________________________________________________________________\n");
	}
}
