package project.management.VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import project.management.ControlAndManagement;
import project.management.VendingMachine.interfaceMachine.IMachine;
import project.management.VendingMachine.interfaceMachine.impl.Machine;
import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;
import project.management.service.IStatisticsService;
import project.management.service.impl.StatisticsService;

public class MachineComputer {
	private List<ProductEntity> productEntities;
	private List<StoreMachineEntity> storeMachineEntities;
	private ProductEntity product;
	private HashMap<String, Integer> orderProduct;
	private Scanner scan;
	private IMachine machine;
	private IStatisticsService statisticsService;
	
	
	public MachineComputer() {
		this.productEntities = new ArrayList<>();
		this.storeMachineEntities = new ArrayList<>();
		this.product = new ProductEntity();
		this.orderProduct = new HashMap<>();
		this.scan = new Scanner(System.in);
		this.machine = new Machine();
		this.statisticsService = new StatisticsService();
	}
	
	
	public void choiceMachine(int money) {
		ControlAndManagement controlAndManagement = new ControlAndManagement();
		storeMachineEntities = statisticsService.findAllMachine();
		System.out.println("select machine: ");
		System.out.println("--------------------------MENU---------------------------");
		for (int i = 0; i < storeMachineEntities.size(); i++) {
			System.out.println("--- id " + i + " || name: " + storeMachineEntities.get(i).getName() + " || address: "
					+ storeMachineEntities.get(i).getAddress() + " ---");

			productEntities = statisticsService.findByMachine(storeMachineEntities.get(i).getId());
			if (productEntities != null) {
				for (int j = 0; j < productEntities.size(); j++) {
					product = productEntities.get(j);
					orderProduct.put(product.getName(), 0);
				}
			} else {
				System.out.println("No product of " + storeMachineEntities.get(i).getName());
			}
		}
		boolean checkMore = true;
		System.out.println("--------------------------------------------------------");
		System.out.println("input id machine:");
		int idMachine = scan.nextInt();
		System.out.println("are you sure to machine:" + storeMachineEntities.get(idMachine).getName() + "|| input y or n or out(out to select main menu)");
		String key = scan.next();
		switch (key) {
		case "y": {
			productEntities = statisticsService.findByMachine(storeMachineEntities.get(idMachine).getId());
			machine.order_machine(checkMore, money, productEntities, orderProduct, storeMachineEntities.get(idMachine),machine);
			break;
		}
		case "n": {
			new MachineComputer().choiceMachine(money);;
			break;
		}
		case "out": {
			// return Main menu
			controlAndManagement.run();
		}
		default:
			// return Main menu
			System.out.println("you choose wrong out to main menu");
			controlAndManagement.run();
		}
	}
}