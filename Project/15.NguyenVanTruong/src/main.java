import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Customer;
import entity.Game;
import entity.ReceiptEntity;
import entity.User;
import repository.BuyGameRepository;
import repository.CustomerRepository;
import repository.CustomerRepositoryImpl;
import repository.GameRepository;
import repository.GameRepositoryImpl;
import repository.ReceiptRepository;
import repository.ReceiptRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;



public class main {
	 static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String answer;
		int key=0;
		int keyfn;
		
		UserRepository usRepo = new UserRepositoryImpl();
		List<User> lsUser = new ArrayList();
		lsUser = usRepo.infoUser();
		BuyGameRepository buyGameRep = new BuyGameRepository();
		User us = new User();
		GameRepository gameRepository = new GameRepositoryImpl();
		Game gm = new Game();
		CustomerRepository customerRepository = new CustomerRepositoryImpl();
		List<Customer> lsCustomers = new ArrayList();
		Customer cus = new Customer();
		ReceiptRepository receiptRepository = new ReceiptRepositoryImpl();
		List<ReceiptEntity> lsReceiptEntities = new ArrayList();
		ReceiptEntity receiptEntity = new ReceiptEntity();
		System.out.println("Please select 1. Admin 2.User");
		int selectActor = sc.nextInt();
		if(selectActor==1) {
			usRepo.signIn();
			System.out.println("Please select function:1. Management Game 2.Management User 3.Management Customer 4.Management Receipt 5.Exit");
			key = sc.nextInt();
			if(key ==1) {
				System.out.println(" Management Game");
				System.out.println("Please select:"+"1.Add new game");
				System.out.println("\t\t"+"2.Update game");
				System.out.println("\t\t"+"3.Delete game");
				keyfn = sc.nextInt();
				if(keyfn == 1) {
					System.out.println("input new name game");
					String nameGame = sc.next();
					gm.setName(nameGame);
					System.out.println("input price game");
					int price = sc.nextInt();
					gm.setPrice(price);
					System.out.println("input producer");
					String producer = sc.next();
					gm.setProducer(null);
					System.out.println("input key game");
					String keyGame = sc.next();
					gm.setKey_game(null);
					gameRepository.add(gm);
					System.out.println("Add game success");
					
					}
				if(keyfn == 2) {
					System.out.println("input name");
					String nameGame = sc.next();
					gm.setName(nameGame);
					System.out.println("input price");
					int price = sc.nextInt();
					gm.setPrice(price);
					System.out.println("input producer");
					String producer = sc.next();
					gm.setProducer(producer);
					System.out.println("input key");
					String keyGame = sc.next();
					gm.setKey_game(keyGame);
					System.out.println("input id_game");
					int idGame = sc.nextInt();
					gm.setId_game(idGame);
					gameRepository.update(gm);
					System.out.println("Updated is success");
					
				}
				if(keyfn == 3) {
					System.out.println("input id game want to delete");
					int idGame = sc.nextInt();		
					gameRepository.delete(idGame);
					System.out.println("Deleted success");
					
				}
				
			}
			if(key ==2 ) {
				System.out.println("  Management User");
				System.out.println("Select function");
				System.out.println("1. Update user");
				System.out.println("2.Delete user ");
				keyfn = sc.nextInt();
				if(keyfn == 1) {
					System.out.println("input password");
					String passWord = sc.next();
					us.setPassword(passWord);
					System.out.println("input id");
					int id = sc.nextInt();
					us.setId(id);
					usRepo.update(us);
					System.out.println("Updated is success");
				}
				if(keyfn == 2) {
					System.out.println("input id");
					int idUS = sc.nextInt();
					usRepo.delete(idUS);
					System.out.println("Deleted is success");
				}
			}
			if(key == 3) {
				System.out.println("Management Customer");
				System.out.println("Select funcion");
				System.out.println("1. Update customer");
				System.out.println("2. Delete  customer");
				keyfn = sc.nextInt();
				
				if(keyfn == 1) {
					System.out.println("input name_customer");
					String nameCustomer = sc.next();
					cus.setName_customer(nameCustomer);
					System.out.println("input money");
					int money = sc.nextInt();
					cus.setMoney(money);
					System.out.println("input numberphone");
					String numberPhone = sc.next();
					cus.setNumberphone(numberPhone);
					System.out.println("input email");
					String eMail = sc.next();
					cus.setMail(eMail);
					System.out.println("input id_customer");
					int idCustomer = sc.nextInt();
					cus.setId_customer(idCustomer);
					customerRepository.update(cus);
					System.out.println("Updated success");
				}
				if(keyfn == 2) {
					System.out.println("Input id_customer");
					int idCustomer = sc.nextInt();
					customerRepository.delete(idCustomer);
					System.out.println("Deleted success");
				}
			}
			if(key == 4) {
				System.out.println("Management Receipt");
				System.out.println("Select function");
				System.out.println("1. Update receipt");
				System.out.println("2. Delete receipt");
				System.out.println("3. Print receipt");
				keyfn = sc.nextInt();
				
				if(keyfn ==1 ) {
					System.out.println("Update receipt");
					System.out.println("input name_customer");
					String nameCustomer = sc.next();
					receiptEntity.setName_customer(nameCustomer);
					System.out.println("input phone_customer");
					String phoneNumber = sc.next();
					receiptEntity.setPhone_customer(nameCustomer);
					System.out.println("input name_game");
					String nameGame = sc.next();
					receiptEntity.setName_game(nameGame);
					System.out.println("input Price");
					int price = sc.nextInt();
					receiptEntity.setPrice(price);
					System.out.println("input producer");
					String producer = sc.next();
					receiptEntity.setProducer(producer);
					System.out.println("input total");
					double total = sc.nextDouble();
					receiptEntity.setTotal(total);
					System.out.println("input id");
					int id = sc.nextInt();
					receiptEntity.setId(id);
					receiptRepository.update(receiptEntity);
					System.out.println("Updated success");
				}
				if(keyfn == 2) {
					System.out.println("input id");
					int id = sc.nextInt();
					receiptRepository.delete(id);
					System.out.println("Deleted success");
				}
				if(keyfn == 3) {
					
					//System.out.println("findByID");
					//int id = sc.nextInt();
					lsReceiptEntities = receiptRepository.printReceipt();
//					for (int i = 0; i <lsReceiptEntities.size();  i++) {
//					
//					}
					System.out.println("input id receipt");
					int id = sc.nextInt();
					lsReceiptEntities = receiptRepository.findById(id);
					for(int i = 0; i<lsReceiptEntities.size();i++) {
						System.out.print(lsReceiptEntities.get(i).getId()+"\t");
						System.out.print(lsReceiptEntities.get(i).getName_customer()+"\t");
						System.out.print(lsReceiptEntities.get(i).getName_game()+"\t");
						System.out.print(lsReceiptEntities.get(i).getPrice()+"\t");
						System.out.println(lsReceiptEntities.get(i).getTotal()+"\t");
					}
				}
			}
			if(key == 5) {
				System.out.println("GoodBye see you soon");
			}
			
		
			
			//gameRepository.add(gm);
			
		}
		if(selectActor == 2) {
		//receiptRepository = receiptRepository.findById(id);
		 System.out.println("Please select 1.sign in 2. sign up");
		  key =sc.nextInt();
		switch (key) {
		case 1:
			usRepo.signIn();
			buyGameRep.selectGame();
			break;
		case 2:		
			 usRepo.signUp();
				System.out.println("input information");
				System.out.println("input name-customer");
				String nameCustomer = sc.next();
				cus.setName_customer(nameCustomer);
				cus.setMoney(50);
				System.out.println("input numberphone");
				String numberPhone = sc.next();
				cus.setNumberphone(numberPhone);
				System.out.println("input mail");
				String mail = sc.next();
				cus.setMail(mail);
				customerRepository.add(cus);
				System.out.println("add information success");
				System.out.println("show info");
				lsCustomers = customerRepository.findAll();
				for(int i= lsCustomers.size()-1;i<lsCustomers.size();i++) {
					System.out.println("id_customer:"+lsCustomers.get(i).getId_customer());
					System.out.println("id_user:"+lsCustomers.get(i).getId_user());
					System.out.println("name_customer:"+lsCustomers.get(i).getName_customer());
					System.out.println("money:"+lsCustomers.get(i).getMoney());
					System.out.println("numberphone:"+lsCustomers.get(i).getNumberphone());
					System.out.println("mail:"+lsCustomers.get(i).getMail());
				}
				
			 System.out.println("Do you want sign in?");
			  answer = sc.next();
			 if(answer.equals("Y")) {
				 usRepo.signIn();
				 buyGameRep.selectGame();
				 break;
			 }if (answer.equals("N")){
				 System.out.println("Goodbye See you soon");
			 }
			break;
		}
	//	cusRepository.delete("3");
//		infoGame igame = new infoGame();
//		 igame.setName("addad");
//		 igame.setPrice(500);
//		Dao_game dgame= new Dao_game();
//		dgame.add(igame);
	}
	}

}
