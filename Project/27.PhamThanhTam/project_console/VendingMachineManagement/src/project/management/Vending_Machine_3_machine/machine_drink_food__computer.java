package project.management.Vending_Machine_3_machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import project.management.ControlAndManagement;
import project.management.Vending_Machine_3_machine.interfaceMachine.IMachine;
import project.management.Vending_Machine_3_machine.interfaceMachine.impl.Machine;
import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;
import project.management.service.IStatisticsService;
import project.management.service.impl.StatisticsService;

public class machine_drink_food__computer {
	public machine_drink_food__computer(int money) {

		List<ProductEntity> productEntities = new ArrayList<>();
		List<StoreMachineEntity> storeMachineEntities = new ArrayList<>();
		ProductEntity product = new ProductEntity();
		HashMap<String, Integer> orderProduct = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		IMachine machine = new Machine();
		IStatisticsService statisticsService = new StatisticsService();
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
			new machine_drink_food__computer(money);
			break;
		}
		case "out": {
			new ControlAndManagement();
			break;
		}
		default:
			
			System.out.println("you choose wrong out to main menu");
			new ControlAndManagement();
			break;
		}
		
	}

}