import java.util.Scanner;

public class Machine {
	static String answer;
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int money;
	boolean flag = true;
	int priceCola = 15000;
	int pricePepsi = 20000;
	int priceTea = 10000;
	int minCost = 10000;
	int priceMilk = 10000;
	int priceCoffee = 15000;
	int priceWater = 10000;
	do {
	
	System.out.println("Please input money more 10000vnd");
	money = scan.nextInt();
	}while(money<10000);
	do {
	System.out.println("Choose your product");
	System.out.println("0. Cola");
	System.out.println("1. Pepsi");
	System.out.println("2. Tea");
	System.out.println("3. Milk");
	System.out.println("4. Coffee");
	System.out.println("5. Water");
	int x = scan.nextInt();
	switch(x) {
	case 0:
		System.out.println("cola");
		if(money>=priceCola) {
			System.out.println("Thank you");
			System.out.println("Your moneyy return :"+(money-priceCola) );
			System.out.println("Do you want to continue buy Y/N?");
			 answer = scan.next();
		}else {
			System.out.println("Your money no enough.Please input more money");
		}
		break;
	case 1:
		System.out.println("pepsi");
		if(money>=pricePepsi) {
			System.out.println("Thank you");
			System.out.println("Your moneyy return :"+(money-pricePepsi) );
			System.out.println("Do you want to continue buy Y/N?");
			 answer = scan.next();
		} else {
			System.out.println("Your money no enough.Please input more money");
			flag=true;
		}
		break;
	case 2:
		System.out.println("tea");
		if(money>=priceTea) {
			System.out.println("Thank you");
			System.out.println("Your moneyy return :"+(money-priceTea) );
			System.out.println("Do you want to continue buy Y/N?");
			 answer = scan.next();
		} else {
			System.out.println("Your money no enough.Please input more money");
		}
		break;
	
	case 3:
		System.out.println("Milk");
	if(money>=priceMilk) {
		System.out.println("Thank you");
		System.out.println("Your moneyy return :"+(money-priceMilk) );
		System.out.println("Do you want to continue buy Y/N?");
		 answer = scan.next();
	} else {
		System.out.println("Your money no enough.Please input more money");
	}
	break;
	case 4:
		System.out.println("Coffee");
		if(money>=priceCoffee) {
			System.out.println("Thank you");
			System.out.println("Your moneyy return :"+(money-priceCoffee) );
			System.out.println("Do you want to continue buy Y/N?");
			 answer = scan.next();
		} else {
			System.out.println("Your money no enough.Please input more money");
		}
		break;
	case 5:
		System.out.println("Water");
		if(money>=priceWater) {
			System.out.println("Thank you");
			System.out.println("Your moneyy return :"+(money-priceWater) );
			System.out.println("Do you want to continue buy Y/N?");
			 answer = scan.next();
		} else {
			System.out.println("Your money no enough.Please input more money");
		}
		break;
	}
	} while(answer.equals("Y") || (flag=true));

	
	}
}


