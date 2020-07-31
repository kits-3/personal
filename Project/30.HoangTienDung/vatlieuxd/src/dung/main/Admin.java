package dung.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dung.connect.Dao;
import dung.connect.LogIn;
import dung.dto.Product;
import dung.dto.User;
import dung.function.Register;

public class Admin {
	
	static Dao dao = new Dao();
	static Scanner scan = new Scanner(System.in);
	static List<User> lsUser = new ArrayList<>();
	static Product product = new Product();
	static List<Product> ls = dao.findProduct();
	
	public void amin(User user) {
		System.out.println("Well come "+user.getRole_name()+"!\n");
		dao.viewInfo(user.getId());
		System.out.println("_____________________________________________________________________________________________\n");
		boolean checkout = true;
		do {
			lsUser = dao.findUser();// cap nhat du lieu trong console
			System.out.println("1-Users\t\t2-Info\t\t3-Product\t4-Order\t\t5-Output\t6-Input\t\t7-Logout\n");
			System.out.print("input choice: ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {// users--------------------
				boolean actionUser = true;
				do {
					dao.showAllUser();
					System.out.println("1-Add-new\t2-Delete-user\t3-Permmison\t4-Change-pass-acc\t5-Exit\n");
					System.out.print("input choice: ");
					int choice1 = scan.nextInt();
					switch (choice1) {
					case 1: {//add new user
						addNewUser();
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					case 2: {// delete user--------------------------
						lsUser = dao.findUser();
						dao.showAllUser();
						boolean actionDelete = false;
						do {
							System.out.print("Input id user delete: ");
							int idDelete = scan.nextInt();
							int id = timIndex(lsUser, idDelete);// tim index trong list user
							System.out.println(user.getUser()+lsUser.get(id).getUser());
							if (dao.Permmis(user.getUser(),lsUser.get(id).getUser())) {// kiem tra id
																						// role_admin < id
																						// role_user
								dao.deleteUser(idDelete);
								lsUser = dao.findUser();
								dao.showAllUser();
								actionDelete = YorN();
							} else {
								System.out.println("Can't delete user!!!");
								actionDelete = YorN();
							}
						} while (actionDelete);
						System.out.println("Exit-delete-User!");
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					case 3: { // permmison user---------------------------------
						boolean actionPermis = false;
						do {
							lsUser = dao.findUser();
							dao.showAllUser();
							System.out.print("Input id permmison: ");
							int idPermis = scan.nextInt();
							int id = timIndex(lsUser, idPermis);// tim index trong list user
							if (dao.Permmis(user.getUser(), lsUser.get(id).getUser())) {// kiem tra id
																						// role_admin < id
																						// role_user
								System.out.print("Input permmison (client or person): ");
								String role_name = scan.next();
								if (role_name.equalsIgnoreCase("client")
										|| role_name.equalsIgnoreCase("person")) {
									dao.addPermmison(idPermis, role_name);
									lsUser = dao.findUser();// cap nhat du lieu trong console
									dao.showAllUser();
									actionPermis = YorN();
								} else {
									actionPermis = YorN();
								}
							} else {
								System.out.println("Can't permmison user!!!");
								actionPermis = YorN();
							}
						} while (actionPermis);
						System.out.println("Exit-Permmison!");
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					case 4: {// change pass acc---------------
						dao.changePass(user);
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					default:
						actionUser = false;
						break;
					}

				} while (actionUser);
				System.out.println("Exit-User!");
				System.out.println("_____________________________________________________________________________________________\n");
				checkout = YorN();
				break;
			}
			case 2: {// info----------------------------------
				boolean actionInfo = true;
				do {
					lsUser = dao.findUser();
					dao.showAllUser();
					System.out.println("1-View-user\t2-Change-info-user\t3-Exit\n");
					System.out.print("Input choice: ");
					int choice2 = scan.nextInt();
					switch (choice2) {
					case 1: {// view info user
						viewInfoUser();
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					case 2: {// update info
						thayDoiInfo();
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					default: {
						actionInfo = false;
						break;
					}
					}

				} while (actionInfo);
				System.out.println("Exit-Info!");
				System.out.println("_____________________________________________________________________________________________\n");
				checkout = YorN();
				break;
			}
			case 3: {// product----------------------
				boolean actionProduct = true;
				do {
					System.out.println("1-Insert-Product\t2-Delete-Product\t3-Update-Product\t4-Exit\n");
					System.out.print("Input choice: ");
					int choice3 = scan.nextInt();
					switch (choice3) {
					case 1: {//add product
						themProduct();
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					case 2: {//delete product
						xoaProduct();
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					case 3: {//update produc
						thayDoiTTPro();
						System.out.println("_____________________________________________________________________________________________\n");
						break;
					}
					default: {
						actionProduct = false;
						break;
					}
					}
				} while (actionProduct);
				System.out.println("Exit-Product!");
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 4: {//order
				ShowOrder();
				System.out.println("Exit-Order!");
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 5: {
				dao.ShowOutput();
				System.out.println("Exit-Output!");
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			case 6: {
				dao.ShowInput();
				System.out.println("Exit-Input!");
				System.out.println("_____________________________________________________________________________________________\n");
				break;
			}
			default:
				checkout = false;
				break;
			}
		} while (checkout);
		System.out.println("_____________________________________________________________________________________________\n");
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

	static int timIndex(List<User> lsUser, int id_user) {
		int id = -1;
		for (int i = 0; i < lsUser.size(); i++) {
			if (id_user == lsUser.get(i).getId())
				id = i;
		}
		return id;
	}
	static void addNewUser() {
		User smalluser = new User();
		boolean actionNew = true;
		do {
			System.out.print("Input user_name:");
			String user_name = scan.next();
			
			LogIn login = new LogIn();

			if (login.checkDuplicate(user_name)) {// kiem tra co trung user da tao ko
				System.out.println("User_name used!");
				actionNew = YorN();
			} else {
				System.out.print("Input password:");
				String password = scan.next();
				System.out.print("Input permmison: (client or person)");
				String role_name = scan.next();
				if (role_name.equals("client")
						|| role_name.equals("person")) {
					smalluser.setId(0);
					smalluser.setUser(user_name);
					smalluser.setPassword(password);
					smalluser.setRole_name(role_name);
					dao.addUser(smalluser);// them user vao sql
					Register register = new Register();
					register.addInfo(smalluser);// tao info vao sql
					System.out.println("add new complete!");
					lsUser = dao.findUser();// cap nhat du lieu trong console
					dao.showAllUser();
					actionNew = YorN();
				} else {
					System.out.println("Input false!");
					actionNew = YorN();
				}
			}
		} while (actionNew);
		System.out.println("Exit-add-User!");
	}
	
	
	
	
	static void viewInfoUser() {
		boolean actionView = true;
		do {
			System.out.print("Input id view info:");
			int idView = scan.nextInt();
			int id = timIndex(lsUser, idView);
			if (id == -1) {
				System.out.println("false!");
				actionView = YorN();
			} else {
				dao.viewInfo(idView);
				actionView = YorN();
			}
		} while (actionView);
		System.out.println("Exit-View-Info!");
	}
	
	
	static void thayDoiInfo() {
		boolean actionChangeInfo = true;
		do {
			lsUser = dao.findUser();
			dao.showAllUser();
			System.out.print("Input id change info: ");
			int idChangeInfo = scan.nextInt();
			int id = timIndex(lsUser, idChangeInfo);
			if (id == -1) {
				System.out.println("false!");
				actionChangeInfo = YorN();
			} else {
				dao.changeInfo(lsUser.get(id));
				actionChangeInfo = YorN();
			}
		} while (actionChangeInfo);
		System.out.println("Exit-Change-Info!");
	}
	
	static void themProduct() {
		boolean actionAddPro = true;
		do {
			try {
				System.out.println("Quantity 1");
				System.out.print("Input name product: ");
				String name_pro = scan.next();
				System.out.print("Input price_in: ");
				double price_in = scan.nextDouble();
				System.out.print("Input price_out: ");
				double price_out = scan.nextDouble();
				product.setId(0);
				product.setName(name_pro);
				product.setPrice_in(price_in);
				product.setPrice_out(price_out);
				product.setQuantity(1);
				dao.addProduct(product);
				ls = dao.findProduct();// cap nhat product tren console
				dao.printProduct();
				actionAddPro = YorN();
			} catch (Exception e) {
				// TODO: handle exception
				actionAddPro = false;
			}

		} while (actionAddPro);
		System.out.println("Exit-Add-Product!");
	}
	
	static void xoaProduct() {
		boolean actionDelPro = true;
		do {
			try {
				ls = dao.findProduct();
				dao.printProduct();
				System.out.print("Input id product delete: ");
				int id_pro = scan.nextInt();
				dao.DeleteProduct(id_pro);
			} catch (Exception e) {
				// TODO: handle exception
				actionDelPro = false;
			}
			actionDelPro = YorN();
		} while (actionDelPro);
		System.out.println("Exit-Delete-Product!");
	}
	
	static void thayDoiTTPro() {
		boolean actionUpdatePro = true;
		do {
			try {
				ls = dao.findProduct();
				dao.printProduct();
				System.out.print("Input id product update: ");
				int id_pro = scan.nextInt();
				int id = -1;
				for (int i = 0; i < ls.size(); i++) {
					if (id_pro == ls.get(i).getId()) {
						id = i;
					}
				}
				if (id != -1) {
					System.out.print("Input name product change: ");
					String name_pro = scan.next();
					System.out.print("Input price_in change: ");
					double price_in = scan.nextDouble();
					System.out.print("Input price_out change: ");
					double price_out = scan.nextDouble();
					product.setId(id_pro);
					product.setName(name_pro);
					product.setPrice_in(price_in);
					product.setPrice_out(price_out);
					product.setQuantity(1);
					dao.UpdateProduct(product);
					ls = dao.findProduct();
					dao.printProduct();
				} else {
					System.out.println("Input false!");
				}
			} catch (Exception e) {
				// TODO: handle exception
				actionUpdatePro = false;
			}
			actionUpdatePro = YorN();
		} while (actionUpdatePro);
		System.out.println("Exit-Update-Product!");
	}
	
	static void ShowOrder() {
		boolean actionOrder = true;
		do {
			dao.ShowOrder();
			System.out.print("Are you delete order? (y/n?)");
			String delOrder = scan.next();
			if (delOrder.equalsIgnoreCase("y")) {
				System.out.print("input id order: ");
				int id_order = scan.nextInt();
				dao.delOrder(id_order);
				actionOrder = YorN();
			} else {
				actionOrder = YorN();
			}

		} while (actionOrder);
	}
}
