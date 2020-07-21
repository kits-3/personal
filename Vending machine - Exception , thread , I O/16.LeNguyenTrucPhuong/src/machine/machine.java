package machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class machine {
	static List<String> product = new ArrayList();
	static List<Integer> productPrice = new ArrayList();
	static List<String> productadd = new ArrayList();
	static List<Integer> priceadd = new ArrayList();
	static int money;
	
	public static int inputMoney(int money) {
		 System.out.println("in put money");
		 Scanner sc = new Scanner(System.in);
		 int mn =sc.nextInt();
		 
		 return mn;	
	}
	
	public static int minMoney(int minmoney)
	{
		int min =productPrice.get(0);
		for (int i = 0; i < productPrice.size(); i++) 
		{
			if (min>=productPrice.get(i))
			{
				min=productPrice.get(i);
				 minmoney=min;
			}
		}
		return minmoney;
	}
	public static int addreturnMoney(int m1){
		System.out.println("money < price product , you choose");
		System.out.println("1 is return money");
		System.out.println("2 is add money");
		 Scanner sc2 = new Scanner(System.in);
		 int pro2 =sc2.nextInt();
		 if(pro2!=2) {
			 System.out.println("Goodbye ");
			 return 0;
		 }
		 else {
			 
				money+= inputMoney(money);
				System.out.println(" your money  :" +money);
				//checkMoney();
				
				return money;
		 }	
}
	public static void checkMoney() {
		int min = 0;
		min = minMoney(min);
		if (money < min) {
			int m=0;
			m = addreturnMoney(m);
			if(m!=0) {
				money=m;
				checkMoney();
				}
		} else
			chooseProduct();
	}
	
	public static void chooseContinue( ) 
	{
		System.out.println(" you choose ");
		System.out.println("1 is want more");
		System.out.println("2 is end");
		 Scanner sc2 = new Scanner(System.in);
		  int c =sc2.nextInt();
		 if(c!=1) 
		 {
			 System.out.println("Thanks and goodbye!! ");

		 }
		 else 
		 {	 checkMoney();	 }
	}
	public static void chooseProduct() {
		
		for (int i = 0; i< productPrice.size(); i++) {
			System.out.print(product.get(i));
			System.out.println(" : " +productPrice.get(i));
			}
		System.out.println("your choice");
		Scanner sc1 = new Scanner(System.in);
		String pro =sc1.next();
		for (int i = 0; i < product.size(); i++)  {
			if (pro.equals(product.get(i))) {
				if (money >=productPrice.get(i)) {
					money-=productPrice.get(i);
					System.out.print("your select :" +product.get(i));
					productadd.add(product.get(i));
					priceadd.add(productPrice.get(i));
					System.out.println(" ; your money " +money);
					int b=0;
					chooseContinue() ;
				}
				else {
					int m=0;
					m=addreturnMoney(m);
					if(m!=0) {
						money=m;
						if (money >= productPrice.get(i)) {
							money -= productPrice.get(i);
							System.out.print("your select :" + product.get(i));
							productadd.add(product.get(i));
							priceadd.add(productPrice.get(i));

							System.out.println(" ; your money " + money);
							int b = 0;
							chooseContinue();
						}
						
						
						
						
					}
					
				}		}		}
		
	}
	public static void name() {
		/*
		 * product.add("coca"); product.add("milk"); product.add("coki");
		 * product.add("juice");
		 * 
		 * productPrice.add(600); productPrice.add(400); productPrice.add(900);
		 * productPrice.add(100);
		 */
	}
	


	public static void main(String[] args) {
		/*
		 * name();
		 * 
		 * money=inputMoney(money); chooseProduct(); int min=0; min=minMoney(min);
		 * checkMoney();
		 */
		

}}
