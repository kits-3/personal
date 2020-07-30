package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Customer;
import entity.Game;
import entity.ReceiptEntity;

public class BuyGameRepository {
	static Scanner sc = new Scanner(System.in);
	//static int money;

	


 public void selectGame() {
		int currentMoney;
	 int key =0;
	 String answer;
	 int moreMoney;
	 CustomerRepository cusRepo = new CustomerRepositoryImpl();
		List<Customer> lscus = new ArrayList();
		Customer cus = new Customer();
		lscus = cusRepo.findAll();
		//ReceiptRepository receiptRepository = new ReceiptRepositoryImpl();
	List<ReceiptEntity> lsReceiptEntities = new ArrayList();
	 
		
		//cus.setMoney(1000);
		//cusRepo.update(cus);
	 System.out.println("Please select game");
	 System.out.println("ID_GAME"+"\t\t"+"NAME_GAME"+"\t"+"PRICE"+"\t\t"+"PRODUCER"+"\t");
		GameRepository gameRepo = new GameRepositoryImpl();
		List<Game> lsgm = new ArrayList();
		lsgm = gameRepo.infoGame();	
		ReceiptRepository receiptRepository = new ReceiptRepositoryImpl();
		ReceiptEntity receiptEntity = new ReceiptEntity();
		for (int i = 0; i < lsgm.size(); i++) {
			System.out.print(lsgm.get(i).getId_game()+"."+"\t\t");
			System.out.print(lsgm.get(i).getName()+"\t\t");
			System.out.print(lsgm.get(i).getPrice()+"\t\t");
			System.out.println(lsgm.get(i).getProducer()+"\t");
			}
		 key = sc.nextInt();
	
		switch(key) {
		
		case 1://System.out.println(money);
			 System.out.println("please input index");
			 int index = sc.nextInt();
			 System.out.println("input id_customer");
			 int id_customer = sc.nextInt();
			//System.out.println(lscus.get(index).getMoney());
				if(lscus.get(index).getMoney() < lsgm.get(0).getPrice()){
					System.out.println("Do you input more money?");
					answer = sc.next();
					if(answer.equals("N")) {
						System.out.println("Goodbye See you soon");
						break;
					}			
					if(answer.equals("Y")) {
						System.out.println("Input more money");
						moreMoney = sc.nextInt();
						cus.setMoney(moreMoney+lscus.get(index).getMoney());
						cus.setId_customer(id_customer);
						cusRepo.updateMoney(cus);
					selectGame();
					
//					System.out.println(lsgm.get(0).getKey_game());
//					System.out.println("Please input yourname and yourphone");
//					String yourName = sc.next();
//					String yourPhone = sc.next();
//					receiptEntity.setName_customer(yourName);
//					receiptEntity.setPhone_customer(yourPhone);
//					receiptEntity.setName_game(lsgm.get(0).getName());
//					receiptEntity.setPrice(lsgm.get(0).getPrice());
//					receiptEntity.setProducer(lsgm.get(0).getProducer());
//					receiptEntity.setTotal(lsgm.get(0).getPrice());
//					receiptRepository.add(receiptEntity);
//					System.out.println("Do you want show your bill? Y/N");
//					String slBill = sc.next();
//					if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
//					else if(slBill.equals("Y")) {
//					lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
//					for(int i = 0; i<lsReceiptEntities.size();i++) {
//						System.out.print(lsReceiptEntities.get(i).getId()+"\t");
//						System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
//						System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
//						System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
//						System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
//						
//					}}
					break;
			}
			}
							
				else if(lscus.get(index).getMoney()>=lsgm.get(0).getPrice()) {
			
			
		}
		currentMoney = lscus.get(index).getMoney()-lsgm.get(0).getPrice();
		System.out.println("Your money now:"+currentMoney);
		cus.setMoney(currentMoney);
		cus.setId_customer(id_customer);
		cusRepo.updateMoney(cus);
		System.out.println("Please input yourname and yourphone");
		String yourName = sc.next();
		String yourPhone = sc.next();
		receiptEntity.setName_customer(yourName);
		receiptEntity.setPhone_customer(yourPhone);
		receiptEntity.setName_game(lsgm.get(0).getName());
		receiptEntity.setPrice(lsgm.get(0).getPrice());
		receiptEntity.setProducer(lsgm.get(0).getProducer());
		receiptEntity.setTotal(lsgm.get(0).getPrice());
		receiptRepository.add(receiptEntity);
		System.out.println("Do you want show your bill? Y/N");
		String slBill = sc.next();
		if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");
		System.out.println(lsgm.get(0).getKey_game());
		break;}
		else if(slBill.equals("Y")) {
		lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
		for(int i = 0; i<lsReceiptEntities.size();i++) {
			System.out.print(lsReceiptEntities.get(i).getId()+"\t");
			System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
			System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
			System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
			//System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
		}}
		
		System.out.println("Do you want buy other game?");
		answer = sc.next();
		if(answer.equals("N")) {
			System.out.println("GoodBye See you soon.This is your key");
			System.out.println(lsgm.get(0).getKey_game());
		}else if(answer.equals("Y")) {
			selectGame();
			break;
		}
			break;
		case 2 :
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(1).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(1).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(1).getPrice()) {
				System.out.println(lsgm.get(1).getKey_game());				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(1).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(1).getName());
			receiptEntity.setPrice(lsgm.get(1).getPrice());
			receiptEntity.setProducer(lsgm.get(1).getProducer());
			receiptEntity.setTotal(lsgm.get(1).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
				break;
		case 3 : 
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(2).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(2).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(2).getPrice()) {
				System.out.println(lsgm.get(2).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(2).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(2).getName());
			receiptEntity.setPrice(lsgm.get(2).getPrice());
			receiptEntity.setProducer(lsgm.get(2).getProducer());
			receiptEntity.setTotal(lsgm.get(2).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		case 4: 
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(3).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);

					selectGame();
					System.out.println(lsgm.get(3).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(3).getPrice()) {
				System.out.println(lsgm.get(3).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(3).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(3).getName());
			receiptEntity.setPrice(lsgm.get(3).getPrice());
			receiptEntity.setProducer(lsgm.get(3).getProducer());
			receiptEntity.setTotal(lsgm.get(3).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		case 5:
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(4).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(4).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(4).getPrice()) {
				System.out.println(lsgm.get(4).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(4).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(4).getName());
			receiptEntity.setPrice(lsgm.get(4).getPrice());
			receiptEntity.setProducer(lsgm.get(4).getProducer());
			receiptEntity.setTotal(lsgm.get(4).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		case 6: 
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(5).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(5).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(5).getPrice()) {
				System.out.println(lsgm.get(5).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(5).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(5).getName());
			receiptEntity.setPrice(lsgm.get(5).getPrice());
			receiptEntity.setProducer(lsgm.get(5).getProducer());
			receiptEntity.setTotal(lsgm.get(5).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		case 7 :
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(6).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(6).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(6).getPrice()) {
				System.out.println(lsgm.get(6).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(6).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(6).getName());
			receiptEntity.setPrice(lsgm.get(6).getPrice());
			receiptEntity.setProducer(lsgm.get(6).getProducer());
			receiptEntity.setTotal(lsgm.get(6).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		case 8 :
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(7).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(7).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(7).getPrice()) {
				System.out.println(lsgm.get(7).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(7).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(7).getName());
			receiptEntity.setPrice(lsgm.get(7).getPrice());
			receiptEntity.setProducer(lsgm.get(7).getProducer());
			receiptEntity.setTotal(lsgm.get(7).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon.This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		case 9:
			 System.out.println("please input index");
			  index = sc.nextInt();
			 System.out.println("input id_customer");
			  id_customer = sc.nextInt();
			if(lscus.get(index).getMoney()<lsgm.get(8).getPrice()) {
				System.out.println("Do you input more money?");
				answer = sc.next();
				if(answer.equals("N")) {
					System.out.println("Goodbye See you soon");
					break;
				} if(answer.equals("Y")) {
					System.out.println("Input more money");
					moreMoney = sc.nextInt();
					cus.setMoney(moreMoney+lscus.get(index).getMoney());
					cus.setId_customer(id_customer);
					cusRepo.updateMoney(cus);
					selectGame();
					System.out.println(lsgm.get(8).getKey_game());
					break;
				}		
			} else if(lscus.get(index).getMoney()>=lsgm.get(8).getPrice()) {
				System.out.println(lsgm.get(8).getKey_game());
				
			}
			currentMoney = lscus.get(index).getMoney()-lsgm.get(8).getPrice();
			System.out.println("Your money now:"+currentMoney);
			cus.setMoney(currentMoney);
			cus.setId_customer(id_customer);
			cusRepo.updateMoney(cus);
			System.out.println("Please input yourname and yourphone");
			 yourName = sc.next();
			 yourPhone = sc.next();
			receiptEntity.setName_customer(yourName);
			receiptEntity.setPhone_customer(yourPhone);
			receiptEntity.setName_game(lsgm.get(8).getName());
			receiptEntity.setPrice(lsgm.get(8).getPrice());
			receiptEntity.setProducer(lsgm.get(8).getProducer());
			receiptEntity.setTotal(lsgm.get(8).getPrice());
			receiptRepository.add(receiptEntity);
			System.out.println("Do you want show your bill? Y/N");
			 slBill = sc.next();
			if(slBill.equals("N")) { System.out.println("Goodbye see you soon. This is your key");break;}
			else if(slBill.equals("Y")) {
			lsReceiptEntities = receiptRepository.findByPhone(yourPhone);
			for(int i = 0; i<lsReceiptEntities.size();i++) {
				System.out.print(lsReceiptEntities.get(i).getId()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
				System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
				System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
				System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
			}}
			System.out.println("Do you want buy other game?");
			answer = sc.next();
			if(answer.equals("N")) {
				System.out.println("GoodBye See you soon. This is your key");
			} else if(answer.equals("Y")) {
				selectGame();
				break;
			}
		break;
		}
		
 }


}
