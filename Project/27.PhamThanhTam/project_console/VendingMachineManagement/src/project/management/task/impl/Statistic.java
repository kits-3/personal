package project.management.task.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project.management.controlandmanagement.IAdmin;
import project.management.controlandmanagement.impl.Admin;
import project.management.entity.OrderItemEntity;
import project.management.entity.OrderItemProductEntity;
import project.management.entity.ProductEntity;
import project.management.entity.StoreMachineEntity;
import project.management.service.IStatisticsService;
import project.management.service.impl.StatisticsService;
import project.management.task.IStatistics;

public class Statistic implements IStatistics {
	private IStatisticsService statisticsService;
	private Scanner scan;
	private IAdmin admin;
	public Statistic() {
		this.statisticsService = new StatisticsService();
		this.scan = new Scanner(System.in);
		
	}

	@Override
	public void statistics() {
		System.out.println("welcome to Find option !!!");
		System.out.println(
				"select option: 4.1 product of a machine || 4.2 finance || 4.3 machine || 4.4 out to select option of ADMIN");
		System.out.println(" please input 1 or 2 or 3 or 4");
		String key = scan.next();
		switch (key) {
		case "1": {
			System.out.println("list product of machine ");
			System.out.println("please input id of machine");
			int id = scan.nextInt();
			findAllProductOfAMachine(id);
			statistics();
			break;
		}
		case "2": {
			finance();
			break;
		}
		case "3": {
			System.out.println("list of machine ");
			findAllMachine();
			statistics();
			break;
		}
		case "4": {
			IAdmin admin = new Admin();
			admin.admin();
			break;
		}
		default:
			System.out.println("you input wrong please unput again");
			statistics();
			break;
		}
	}

	@Override
	public void findAllProductOfAMachine(int id) {
		List<ProductEntity> productEntities = new ArrayList<ProductEntity>();
		productEntities = statisticsService.findByMachine(id);
		for (int i = 0; i < productEntities.size(); i++) {
			System.out.println("---------------------------------------------------------------");
			System.out.println("product ID: " + productEntities.get(i).getId());
			System.out.print(" product name: " + productEntities.get(i).getName());
			System.out.print("|| product price: " + productEntities.get(i).getPrice());
			System.out.println("|| product total: " + productEntities.get(i).getTotal());
		}
		System.out.println("---------------------------------------------------------------");
	}

	@Override
	public void findAllMachine() {
		List<StoreMachineEntity> storeMachineEntities = new ArrayList<>();
		storeMachineEntities = statisticsService.findAllMachine();
		;
		for (int i = 0; i < storeMachineEntities.size(); i++) {
			System.out.println("------------------------------------");
			System.out.println("product ID: " + storeMachineEntities.get(i).getId());
			System.out.print(" product name: " + storeMachineEntities.get(i).getName());
			System.out.print("  || product address: " + storeMachineEntities.get(i).getAddress());
			System.out.println("  || product userid: " + storeMachineEntities.get(i).getUserid());
		}
		System.out.println("------------------------------------");
	}

	@Override
	public void graph(List<StoreMachineEntity> storeMachineEntities, int sumAll) {
		String[][] graph = new String[12][30];
		String[] nameGraph = new String[20];
		int graph_1 = storeMachineEntities.get(0).getSum() * 100 / sumAll;
		int graph_2 = storeMachineEntities.get(1).getSum() * 100 / sumAll;
		int graph_3 = storeMachineEntities.get(2).getSum() * 100 / sumAll;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < 30; j++) {
				graph[i][j] = "  ";
			}
		}
		for (int i = 0; i < 30; i++) {
			graph[11][i] = "*";
		}
		for (int i = 0; i < 12; i++) {
			graph[i][0] = "*";
		}
		graph[0][0] = "^";
		for (int i = 11; i >= 11 - graph_1 / 10; i--) {
			graph[i][3] = "**";
		}
		for (int i = 11; i >= 11 - graph_2 / 10; i--) {
			graph[i][8] = "**";
		}
		for (int i = 11; i >= 11 - graph_3 / 10; i--) {
			graph[i][13] = "**";
		}
		graph[0][0] = "^";
		graph[0][1] = "Sum Money ";
		graph[0][2] = Integer.toString(sumAll);
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 30; j++) {
				System.out.print(graph[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < nameGraph.length; i++) {
			nameGraph[i] = " ";
			nameGraph[3] = "  M1   ";
			nameGraph[6] = "   M2   ";
			nameGraph[9] = "   M3";
			System.out.print(nameGraph[i]);
		}
		/* graph[9- graph_1][3] = "*"; */
		System.out.print(
				"sum money: M1: " + graph_1 + "% || " + storeMachineEntities.get(0).getSum() + "$" + " --- | --- ");
		System.out.print(" M2: " + graph_2 + "% || " + storeMachineEntities.get(1).getSum() + "$" + " --- | --- ");
		System.out.println(" M3: " + graph_3 + "% || " + storeMachineEntities.get(2).getSum() + "$");
		/*----------------- graph------------------------------ */
		System.out.println();
		System.out.println("-------------------	Graph --------------------");

		/*----------------- graph------------------------------ */
	}

	@Override
	public void finance() {

		System.out.println("welcome to 4.2 finance");
		System.out.println("1.sum of money is sold each machine || ProductTotal was sold of this machine "
				+ "|| bil of a machine ||");
		System.out.println("2.graph: money total is sold of each machine");
		System.out.println("3. out to Find option");
		System.out.println("select 1 or 2 or 3");
		String option = scan.next();
		switch (option) {
		case "1": {
			System.out.println("input machineid to select: 1 or 2 or 3 . . .");
			String id = scan.next();
			int max = statisticsService.findAllMachine().size();
			if (Integer.parseInt(id) < max) {
				List<OrderItemEntity> orderItemEntity = new ArrayList<>();
				orderItemEntity = statisticsService.findOrderitemByMachineid(Integer.parseInt(id));

				int moneySum = 0;
				int productTotal = 0;
				for (int i = 0; i < orderItemEntity.size(); i++) {
					moneySum += orderItemEntity.get(i).getMoneytotal();
					List<OrderItemProductEntity> orderItemProductEntities = statisticsService
							.findProductByOrderitem(orderItemEntity.get(i).getId());
					for (OrderItemProductEntity order : orderItemProductEntities) {
						productTotal += order.getCountOrdered();
					}
				}
				System.out.println();
				System.out.println("-----------------option 1----------------------");
				System.out.println();
				System.out.println("sum: " + moneySum + "  ||  " + "bill count: " + orderItemEntity.size()
						+ " ||   ProductTotal: " + productTotal);
				System.out.println();
				System.out.println("-----------------option 1----------------------");
				System.out.println();

			} else {
				System.out.println("you input wrong id machine program out to 4.2 finance");
				finance();
			}
			finance();
			break;
		}
		case "2": {
			int sumAll = 0;
			List<StoreMachineEntity> storeMachineEntitiesMain = statisticsService.findAllMachine();
			System.out.println("please input id of 3 Machine you want to watch graph");
			System.out.println("input id 1: ");
			String machineOneIdString = scan.next();
			System.out.println("input id 2: ");
			String machineSecondIdString = scan.next();
			System.out.println("input id 3: ");
			String machineThirdIdString = scan.next();
			List<StoreMachineEntity> storeMachineEntities = new ArrayList<>();
			for (int i = 0; i < storeMachineEntitiesMain.size(); i++) {
				if (Integer.toString(storeMachineEntitiesMain.get(i).getId()).equals(machineOneIdString)
						|| Integer.toString(storeMachineEntitiesMain.get(i).getId()).equals(machineSecondIdString)
						|| Integer.toString(storeMachineEntitiesMain.get(i).getId()).equals(machineThirdIdString)) {
					storeMachineEntities.add(storeMachineEntitiesMain.get(i));
				}
			}
			if (storeMachineEntities.size() < 3) {
				System.out.println("something wrong please check and select again!!!!!");
				finance();
			}
			for (int i = 0; i < storeMachineEntities.size(); i++) {
				List<OrderItemEntity> orderItemEntities = statisticsService
						.findOrderitemByMachineid(storeMachineEntities.get(i).getId());
				int sum = 0;
				for (OrderItemEntity order : orderItemEntities) {
					sum += order.getMoneytotal();
				}
				storeMachineEntities.get(i).setSum(sum);
				sumAll += storeMachineEntities.get(i).getSum();
			}
			graph(storeMachineEntities, sumAll);
			finance();
			break;
		}
		case "3": {

			statistics();
			break;
		}
		default:
			System.out.println("you input wrong program out to 4.2 finance");
			finance();
			break;
		}
	}

}
