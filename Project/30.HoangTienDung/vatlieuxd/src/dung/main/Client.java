package dung.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dung.connect.Dao;
import dung.dto.Input;
import dung.dto.Order;
import dung.dto.Output;
import dung.dto.Product;
import dung.dto.User;

public class Client {

	static Dao dao = new Dao();
	static Scanner scan = new Scanner(System.in);
	static List<Order> allOrder = new ArrayList<>();
	static List<Product> ls = dao.findProduct();

	boolean checkLogFalse;

	public void client(User user) {
		boolean Choice = true;
		System.out.println("Well come "+user.getRole_name()+"!\n");
		dao.viewInfo(user.getId());
		System.out.println(
				"_____________________________________________________________________________________________\n");
		while (Choice) {
			System.out.print("1-Change-info\t");
			System.out.print("2-check-Order\t");
			System.out.print("3-Input\t\t");
			System.out.print("4-Change-password\t");
			System.out.println("5-Logout");
			System.out.print("\nInput choice: ");
			int intChoice = scan.nextInt();
			switch (intChoice) {
			case 1: {// thay doi thong tin
				dao.changeInfo(user);
				System.out.println("Info after change:");
				dao.viewInfo(user.getId());
				System.out.println("Exit-change-Info!");
				System.out.println(
						"_____________________________________________________________________________________________\n");
				break;
			}
			case 2: {// check order product (mua hang)
				boolean checkOrder = false;
				do {
					checkOrder = false;
					allOrder = dao.allOrder();
					dao.printlistOrder(allOrder);// show order
					System.out.print("\nAdd check?(y/n?): ");
					String add = scan.next();
					if (add.equalsIgnoreCase("y")) {
						System.out.println("Input id order checked:");
						int checked = scan.nextInt();
						int index = -1;
						for (int i = 0; i < allOrder.size(); i++) {
							if (allOrder.get(i).getId() == checked) {
								index = i;
								break;
							}
						}
						if (index == -1) {
							System.out.println("Id false!");
						} else {
							if (allOrder.get(index).getStatus_check().equalsIgnoreCase("none-check")) {
								dao.checkStatus(checked);
								allOrder = dao.allOrder();
								if (allOrder.get(index).getStatus_check().equalsIgnoreCase("checked")) {
									Output output = new Output();
									output.setId(0);
									output.setOr_id(allOrder.get(index).getId());
									output.setUsers_id(user.getId());
									output.setStatus_name(allOrder.get(index).getStatus_check());
									dao.addOutput(output);
									System.out.println("list after checked");
									allOrder = dao.allOrder();
									dao.printlistOrder(allOrder);
									checkOrder= YorN();
								}
							} else {
								System.out.println("Order checked!!");
								checkOrder= YorN();
							}
						}

					} else {
						System.out.println("Out check order");
						checkOrder= false;
					}
				} while (checkOrder);
				System.out.println("Exit-check-Order");
				System.out.println(
						"_____________________________________________________________________________________________\n");
				break;
			}
			case 3: {
				boolean check = false;
				do {
					check = false;
					try {
						dao.printProduct(ls);
						int index = -1;
						System.out.print("Input id product: ");
						int id_Pro = scan.nextInt();
						System.out.print("Input id quantity: ");
						int Quantity = scan.nextInt();
						for (int i = 0; i < ls.size(); i++) {
							if (ls.get(i).getId() == id_Pro) {
								index = i;
								break;
							}
						}
						if (index == -1) {
							System.out.println("Product false!");
							check = true;
						} else {
							Input input = new Input();
							input.setId(0);
							input.setUsers_id(user.getId());
							input.setPro_id(ls.get(index).getId());
							input.setQuantity(Quantity);
							double InMoney = ls.get(index).getPrice_in() * Quantity;
							input.setMoney(InMoney);
							dao.addInput(input);
							System.out.println("add input complete!!");
							System.out.print("add input again??(y/n?)");
							String again = scan.next();
							if (again.equalsIgnoreCase("y"))
								check = true;
							else
								check = false;
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("errrorr...!!");
					}

				} while (check);
				System.out.println("Exit-add-Input!");
				System.out.println(
						"_____________________________________________________________________________________________\n");
				break;
			}
			case 4: {
				dao.changePass(user);
				System.out.println("Exit-change-Password!");
				System.out.println(
						"_____________________________________________________________________________________________\n");
				break;
			}
			case 5: {
				Choice = false;
				break;
			}
			default: {
				Choice = false;
				break;
			}

			}
		}
		System.out.println(
				"_____________________________________________________________________________________________\n");
	}
	
	
	//-------------------------------------------------------methods------------------------------------------------------------------
	static boolean YorN() {
		System.out.print("Again next?(y/n?): ");
		String addregis = scan.next();
		if (addregis.equalsIgnoreCase("y")) {
			return true;
		} else
			return false;
	}

}
