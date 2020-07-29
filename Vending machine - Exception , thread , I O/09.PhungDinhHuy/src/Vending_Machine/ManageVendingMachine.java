package VendingMaChineOOP2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageVendingMachine implements IVendingMachine {

	private List<VendingMachine> listVendingMachine;
//	private List<Product> listProduct;

	ManageVendingMachine() {

		listVendingMachine = new ArrayList<VendingMachine>();

//		listProduct = new ArrayList<Product>();
//		Product product1 = new Product("Coca", 2000);
//		Product product2 = new Product("Pepsi", 3000);
//		Product product3 = new Product("Orange juice", 4000);
//		listProduct.add(product1);
//		listProduct.add(product2);
//		listProduct.add(product3);

		VendingMachine vendingMachine1 = new VendingMachineHCM(1, "Ho Chi Minh city");
		VendingMachine vendingMachine2 = new VendingMachineDN(2, "Đa Nang city");
		VendingMachine vendingMachine3 = new VendingMachineHN(3, "Ha Noi city");

		listVendingMachine.add(vendingMachine1);
		listVendingMachine.add(vendingMachine2);
		listVendingMachine.add(vendingMachine3);

	}

	public VendingMachine chooseVending(int id) {
		VendingMachine ven = null;
		switch (id) {
		case 1:
			ven = new VendingMachineHCM(1, "Ho Chi Minh city");
			break;

		case 2:
			ven = new VendingMachineDN(2, "Đa Nang city");
			break;

		case 3:
			ven = new VendingMachineHN(3, "Ha Noi city");
			break;
		}

		return ven;
	}

	public boolean checkInList(VendingMachine vendingMachine) {
		return (vendingMachine instanceof VendingMachine);
	}

	public void showListVendingMachine() {
		System.out.println("==============   List Vending Machine  =============");
		for (VendingMachine ven : listVendingMachine) {
			System.out.printf("Id: %d \t Name vending machine: %s \n", ven.id, ven.nameMachine);
		}
	}

	@Override
	public void addMachine(VendingMachine vendingMachine) {
		listVendingMachine.add(vendingMachine);

	}

	@Override
	public void deleteMachine(int id) {
		for (int i = 0; i < listVendingMachine.size(); i++) {
			if (listVendingMachine.contains(id)) {
				listVendingMachine.remove(id);
			}
		}

	}

	// Edit name machine
	@Override
	public void editMachine(int id) {

		for (int i = 0; i < listVendingMachine.size(); i++) {
			if (listVendingMachine.contains(id)) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Input change name: ");
				String nameMachine = sc.nextLine();
				listVendingMachine.get(i).setNameMachine(nameMachine);
			}

		}
	}

	public static void main(String[] args) throws InvalidException {
		// add method add/delete/edit for choices (use for manage page)
		// ...
		ManageVendingMachine manageVendingMachine = new ManageVendingMachine();

		Scanner sc = new Scanner(System.in);

		boolean isChooseNextVendingMachine = true;
		do {
			// show List Vending Machine
			manageVendingMachine.showListVendingMachine();
			System.out.println("Plz choose vending machine has id: 1/2/3");
			int choose = sc.nextInt();

			try {
				if (choose > 3 || choose < 0) {
					throw new InvalidException("Invalid choose");

				} else {
					VendingMachine vendingMachine = manageVendingMachine.chooseVending(choose);

					if (manageVendingMachine.checkInList(vendingMachine)) {
						System.out.println("You did choose vending machine: " + vendingMachine.nameMachine);
						//
						vendingMachine.run();
						isChooseNextVendingMachine = false;

					} else {
						isChooseNextVendingMachine = true;
					}
				}
			} catch (Exception ex) {
				System.out.println("Exception is:" + ex);
			}
		} while (isChooseNextVendingMachine);
		

	}

}
