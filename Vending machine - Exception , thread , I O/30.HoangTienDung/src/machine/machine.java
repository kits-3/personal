package machine;


import java.util.List;
import java.util.Scanner;

public class machine {
	
	private static int money;
	private static int minPrice=0;
	private static String note="";
	private static String path="D:/soft/laptrinh/java/du lieu github/30.HoangTienDung/saveVending.txt";
	private static boolean checkMore = true;
	private static Scanner scan;
	public machine(List<product> a) {
		subinterface sub = new subinterface();
		scan = new Scanner(System.in);
		try {
			minPrice = a.get(0).getPrice();
			for(int i=0;i<a.size();i++) {
				if(minPrice>a.get(i).getPrice()) {
					minPrice=a.get(i).getPrice();
				}
			}
			while(checkMore) {
				do {				
					
					if(money<minPrice) {
						sub.dislay(a);
						inputMoney();
						note += money;
						checkMore = true;
						if(money<minPrice)checkMore=check();
					}else if(money>=minPrice){
						checkMore = false;
					}
				}while(checkMore);
				sub.dislay(a);
				System.out.println("Input product :");
				int select = scan.nextInt();
				if(money>=a.get(select-1).getPrice()) {
					money -=a.get(select-1).getPrice();
					System.out.println("You had "+a.get(select-1).getName());
					System.out.println("money :"+money);
					note += a.get(select-1).getName()+money;
					checkMore = check();
				}else if(money<a.get(select-1).getPrice()){
					System.out.println("money : " + money + " not enough !");
					checkMore = check();
					if(checkMore = true) {
						inputMoney();
					}
				}
			}
		}catch(Exception e) {}
		System.out.println("change :"+money+"\n Thank You!!");
		sub.output(note, path);
	}
	
	
	
	static int inputMoney(){
		System.out.println("Your money : "+money);
		System.out.println("Input money :");
		money += scan.nextInt();
		return money;
	}

	
	
	

	
	
	
	
	static boolean check() {
		boolean check = true;
		System.out.print("Are you buy ? (Y/N?)");
		String choice = scan.next();
		if(choice.equalsIgnoreCase("n")) {
			check = false;
		} else if(choice.equalsIgnoreCase("y")) {
			check = true;
		}
		return check;
	}
	}


