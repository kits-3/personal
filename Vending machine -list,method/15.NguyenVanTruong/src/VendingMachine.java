import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

	
	static Scanner scan = new Scanner(System.in);
	static int money =0,moreMoney;
	static List <String> listProduct = new ArrayList<>();
	static int priceCoCa = 1000;
	static int pricePepsi = 800;
	static int priceBeer = 500;
	static int priceCoffee = 400;
	static int priceJuice = 100;
	static boolean checkMore = true;
//	public static void inputMoney (int *a){
//		
//	}
	public static  void checkMoney(int money) {

		String checkString;
//		String selectProduct;

//System.out.println(a);
		do {
			if( money < 100) {
				System.out.println(money);
				System.out.println("You need input more money. Please input Y/N");
				checkString = scan.next();
				if(checkString.equals("Y")) {
					System.out.println("Please input money");
					moreMoney = scan.nextInt();
					money = money + moreMoney;
					System.out.println("Your money now:"+money);
					
				}
				else {			
				if(checkString.equals("N") ){
					System.out.println("GoodBye");	
					checkMore = false;
				}			
					}		
			}
			if(money>=100) {
		System.out.println("Please choose your product");
		listProduct.add("1.CoCa(1000)");
		listProduct.add("2.Pepsi(800)");
		listProduct.add("3.Beer(500)");
		listProduct.add("4.Coffee(400)");
		listProduct.add("5.Juice(100)");
		for (int i = 0; i < listProduct.size(); i++) {
			System.out.print(listProduct.get(i));
		}
		checkProduct();
		checkMore = false;
			}
		}while(checkMore);
			
}
	public static void checkProduct() {
		String selectProduct;
		do {
		selectProduct = scan.next();
		if(selectProduct.equals("CoCa")) {
				System.out.println("Your select: CoCa");
				money = money - priceCoCa;
				System.out.println("Your money now:" +money);
				}		
		else if(selectProduct.equals("Pepsi")) {
			if(pricePepsi>money) {
				checkMore = false;
				checkMoney(money);
				break;
			}
			System.out.println("Your select:Pepsi");
			money = money - pricePepsi;
			System.out.println("Your money now:" +money);
			
		}
		else if(selectProduct.equals("Coffee")) {
			if(priceCoffee>money) {
				checkMore = false;
				checkMoney(money);
				break;
			}
			System.out.println("Your select: Coffee");
			money = money - priceCoffee;
			System.out.println("Your money now:" +money);
		}	else if(selectProduct.equals("Beer")) {
			if(priceBeer>money) {
				checkMore = false;
				checkMoney(money);
				break;
			}
			System.out.println("Your select: Beer");
			money = money - priceBeer;
			System.out.println("Your money now:" +money);
		}
		else if(selectProduct.equals("Juice")) {
			if(priceJuice>money) {
				checkMore = false;
				checkMoney(money);
				break;
			}
			System.out.println("Your select: Juice");
			money = money - priceJuice;
			System.out.println("Your money now:" +money);
		}
		System.out.println("Do you want to buy more?Select Y/N");
		String answer = scan.next();
		if(answer.equals("Y")) {
			checkMore = false;
			checkMoney(money);
			break;
		}
		else if(answer.equals("N")) {
			System.out.println("Goodbye");
		}
		}while(checkMore);
	}
		

	public static void main(String[] args) {

		do {
			System.out.println("Please input your money");
			money += scan.nextInt();

		}while(money<0);

		checkMoney(money);

		
		/* System.out.println("please choose your product"); */
		checkProduct();
	

		}
	
}