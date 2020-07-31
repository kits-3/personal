package project.management.task.impl;

import java.util.Scanner;

import project.management.controlandmanagement.IAdmin;
import project.management.controlandmanagement.impl.Admin;
import project.management.entity.StoreMachineEntity;
import project.management.service.IStoreMachineService;
import project.management.service.impl.StoreMachineService;
import project.management.task.IStoreMachine;

public class StoreMachine implements IStoreMachine{
	private Scanner scan;
	private IStoreMachineService storeMachineService;
	public StoreMachine(){
		this.storeMachineService = new StoreMachineService();
		this.scan = new Scanner(System.in);
	}
	@Override
	public void insertStoreMachine(StoreMachineEntity storeMachineEntity,
			StoreMachineEntity storeMachineAlreadyInserEntity) {
		IAdmin admin = new Admin();
		System.out.println("welcome to insert StoreMachine !!!");
		System.out.println("please input:");
		System.out.println("StoreMachine name: ");
		String name = scan.next();
		System.out.println("StoreMachine address: ");
		String address = scan.next();
		storeMachineEntity.setName(name);
		storeMachineEntity.setUserid(1);
		storeMachineEntity.setAddress(address);
		storeMachineEntity.setStatus(1);;
		storeMachineAlreadyInserEntity = storeMachineService.addStoreMachine(storeMachineEntity);

		System.out.println("StoreMachine name: " + storeMachineAlreadyInserEntity.getName());
		System.out.println("StoreMachine address: " + storeMachineAlreadyInserEntity.getAddress());
		System.out.println("StoreMachine userid:" + storeMachineAlreadyInserEntity.getUserid());
		System.out.println("are you want to insert continues ??? y or n");
		String key = scan.next();
		switch (key) {
		case "y": {
			insertStoreMachine(storeMachineEntity, storeMachineAlreadyInserEntity);
			break;
		}
		case "n": {
			admin.admin();
			break;
		}
		default:
			System.out.println("you choose wrong out to select option");
			admin.admin();
			break;
		}
		
	}

	@Override
	public void updateStoreMachine(StoreMachineEntity storeMachineEntity) {
		IAdmin admin = new Admin();
		System.out.println("welcome to update StoreMachine !!!");
		System.out.println("please input:");
		System.out.println("StoreMachine id: ");
		int id = scan.nextInt();
		StoreMachineEntity oldStoreMachine = storeMachineService.findOneById(id);
		if (oldStoreMachine == null) {
			System.out.println("id is null out to update product");
			updateStoreMachine(storeMachineEntity);
		}
		System.out.println("StoreMachine name: " + oldStoreMachine.getName());
		System.out.println("StoreMachine Address:" + oldStoreMachine.getAddress());
		System.out.println("StoreMachine UserId:" + oldStoreMachine.getUserid());
		System.out.println("are you sure update this StoreMachine ??? y or n");
		String choose = scan.next();
		switch (choose) {
		case "y": {
			
			/* scan.skip("(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?"); */
			System.out.println("StoreMachine name: ");
			String name = scan.next();
			System.out.println("StoreMachine Address:");
			String address = scan.next();
			storeMachineEntity.setId(id);
			storeMachineEntity.setName(name);
			storeMachineEntity.setAddress(address);
			storeMachineEntity = storeMachineService.updateStoreMachine(storeMachineEntity);
			System.out.println("StoreMachine name: " + storeMachineEntity.getName());
			System.out.println("StoreMachine Address:" + storeMachineEntity.getAddress());
			System.out.println("id of Store Machine: " + storeMachineEntity.getId());
			System.out.println("are you want to update continues y or n");
			String key = scan.next();
			switch (key) {
			case "y":
				updateStoreMachine(storeMachineEntity);
				break;
			case "n":
				admin.admin();
				break;

			default:
				System.out.println("you choose wrong out to select");
				admin.admin();
				break;
			}
			break;
		}
		case "n": {
			String option = "2";
			admin.adminOption(option);
			break;
		}
		default:
			System.out.println("select false you return to update");
			updateStoreMachine(storeMachineEntity);
			break;
		}
		
	}

	@Override
	public void deleteStoreMachine() {
		IAdmin admin = new Admin();
		System.out.println("welcome to delete StoreMachine !!!");
		System.out.println("please input id:");
		String id = scan.next();
		storeMachineService.deleteStoreMachine(Integer.parseInt(id));
		System.out.println("do you want to delete continues ??? y or n");
		String key = scan.next();
		switch (key) {
		case "y":
			deleteStoreMachine();
			break;
		case "n":
			admin.admin();
			break;

		default:
			System.out.println("you choose wrong!!!  out to select");
			admin.admin();
			break;
		}
		
	}

}
