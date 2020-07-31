package parkingSystem.repository;

import java.util.Scanner;

import parkingSystem.entity.car;
import parkingSystem.entity.park;
import parkingSystem.entity.parking;
import parkingSystem.entity.user;

public class loginRepositoryImpl implements loginRepository {
	public void login() {
		userRepository userRepo = new userRepositoryImpl();
		carRepository carRepo = new carRepositoryImpl();
		parkingRepository parkingRepo = new parkingRepositoryImpl();
		PositionRepository positionRepo = new PositionRepositoryImpl();
		user User = new user();
		boolean ch=true;
		while(ch) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your account!");
		System.out.println("Username:");
		String un = scan.nextLine();
		System.out.println("Pass:");
		String pw = scan.nextLine();
		boolean c =true;
		boolean d =true;
		boolean h = true;
		if(userRepo.validate(un, pw)==true)
			{
				System.out.println("Correct!");
				if(userRepo.roll(un)==true)
				{
					System.out.println("You are admin!");
					System.out.println("Please choose option:");
					while(d) {
					System.out.println("-------------------------MENU----------------------");
					System.out.println("1.Add || 2.Update || 3.Delete || 4.View || 5.Find by ID || 6.Logout");
					scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					String choose = scan.nextLine();
					switch(choose)
					{
					case "1":
						user a = new user();
						car e = new car();
						parking f = new parking();
						System.out.println("firt name:");
						String fname = scan.next();
						a.setFname(fname);
						System.out.println("Last name:");
						String lname = scan.next();
						a.setLname(lname);
						System.out.println("Phone:");
						String phone = scan.next();
						a.setPhone(phone);
						while(h)
						{
							System.out.println("Username:");
							String username = scan.next();
							if(userRepo.checkLoop(username)==true)
							{
							System.out.println("username has used!");
							System.out.println("Please enter again");
							}
							else {
								h=false;
							}
							a.setUsername(username);
						}
						System.out.println("Pass:");
						String pass = scan.next();
						a.setPass(pass);
						System.out.println("Role:");
						String role = scan.next();
						a.setRole(role);
						int id = userRepo.getID(un);
						e.setId_user(id);
						int id_car = carRepo.getID(id);
						f.setId_car(id_car);
						System.out.println("Car's brand:");
						String brand = scan.next();
						e.setBrand(brand);
						System.out.println("Car's color:");
						String color = scan.next();
						e.setColor(color);
						System.out.println("Select park:");
						System.out.println("1.Pearl plaza || 2.Grand Place || 3.VanHanhMall");
						int pChoose = scan.nextInt();
						switch(pChoose)
						{
						case 1:
							positionRepo.PearlPlaza();
							break;
						case 2:
							positionRepo.GrandPlace();
							break;
						case 3:
							positionRepo.VanHanhMall();
							break;
						default:
							break;
						}
						f.setId_park(pChoose);
						System.out.println("Position: ");
						String position = scan.next();
						f.setPosition(position);
						System.out.println("Date_in (1-30):");
						String date_in = scan.next();
						f.setDate_in(date_in);
						System.out.println("Date_out (1-30):");
						String date_out = scan.next();
						f.setDate_out(date_out);
						int price=Integer.parseInt(date_out)-Integer.parseInt(date_in)*1;
						f.setPrice(String.valueOf(price)+"$");
						f.setId_park(pChoose);
						carRepo.add(e);
						parkingRepo.add(f);
						userRepo.add(a);
						break;
					case "2":
						user b = new user();
						System.out.println("ID:");
						int id1 = scan.nextInt();
						b.setId(id1);
						System.out.println("firt name:");
						String fname2 = scan.next();
						b.setFname(fname2);
						System.out.println("Last name:");
						String lname2 = scan.next();
						b.setLname(lname2);
						System.out.println("Phone:");
						String phone2 = scan.next();
						b.setPhone(phone2);
						System.out.println("Username:");
						String username2 = scan.next();
						b.setUsername(username2);
						System.out.println("Pass:");
						String pass2 = scan.next();
						b.setPass(pass2);
						System.out.println("Role:");
						String role2 = scan.next();
						b.setRole(role2);
						userRepo.update(b);
						break;
					case "3":
						System.out.println("ID:");
						int id2 = scan.nextInt();
						userRepo.delete(id2);
						break;
					case "4":
						userRepo.findAllAdmin();
						break;
					case "5":
						System.out.println("ID:");
						int id3 = scan.nextInt();
						userRepo.findByIdAdmin(id3);
						break;
					case "6":
						System.out.println("SEE YOU!");
						d=false;
						break;
					default:
						break;
					}
					}
				}
				else {
					
					System.out.println("You are user!");
					System.out.println("Please choose option:");
					while(c) {
					System.out.println("---------------------MENU--------------------");
					System.out.println("1.View || 2.Find || 3.Book || 4.Logout");
					scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					String choose = scan.nextLine();
					switch(choose)
					{
					case "1":
						userRepo.findAll();
						
						break;
					case "2":
						System.out.println("ID:");
						int id2= scan.nextInt();
						userRepo.findById(id2);
						break;
					case "3":
						car a = new car();
						parking b = new parking();
						int id = userRepo.getID(un);
						a.setId_user(id);
						int id_car = carRepo.getID(id);
						b.setId_car(id_car);
						System.out.println("Your car's brand:");
						String brand = scan.next();
						a.setBrand(brand);
						System.out.println("Your car's color:");
						String color = scan.next();
						a.setColor(color);
						System.out.println("Select park:");
						System.out.println("1.Pearl plaza || 2.Grand Place || 3.VanHanhMall");
						int pChoose = scan.nextInt();
						switch(pChoose)
						{
						case 1:
							positionRepo.PearlPlaza();
							break;
						case 2:
							positionRepo.GrandPlace();
							break;
						case 3:
							positionRepo.VanHanhMall();
							break;
						default:
							break;
						}
						b.setId_park(pChoose);
						System.out.println("Enter position:");
						String position = scan.next();
						b.setPosition(position);
						System.out.println("Enter date_in (1-30):");
						String date_in = scan.next();
						b.setDate_in(date_in);
						System.out.println("Enter date_out (1-30):");
						String date_out = scan.next();
						b.setDate_out(date_out);
						int price=Integer.parseInt(date_out)-Integer.parseInt(date_in)*1;
						b.setPrice(String.valueOf(price)+"$");
						carRepo.add(a);
						parkingRepo.add(b);
						System.out.println("Book successful!");
						break;
					case "4":
						System.out.println("SEE YOU!");
						c=false;
						break;
					default:
						break;
					}
					
					}
				}
				ch=false;
			}
		
		else {
			System.out.println("Incorrect username or password!");
			System.out.println("1.Enter password  ||  2.Out");
			String po = scan.next();
			switch(po)
			{
			case "1":
				break;
			case "2":
				System.out.println("SEE YOU!");
				ch=false;
				break;
			default:
				break;
				
			}
		}
	 }
	}
}
