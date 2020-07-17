package project;

import java.util.Scanner;

public class machine {
	static final int min =10;
	 static final int coca =30; //coca
	static final int pepsi =20;
	static final int cafe=30;
	static final int milk=20;
	 static int money;

	
	
	
	public static int inputMoney(int money) {
		 System.out.println("in put money");
		 Scanner sc = new Scanner(System.in);
		 int mn =sc.nextInt();
		 System.out.println("tien hien co");
		 return mn;
		
	}
	public static int addreturnMoney(int m1){
			System.out.println("money < price product , you choose");
			System.out.println("1 is return money");
			System.out.println("2 is add money");
			 Scanner sc2 = new Scanner(System.in);
			 int pro2 =sc2.nextInt();
			 if(pro2!=2) {
				 System.out.println("bye ");
				 return 0;
			 }
			 else {
				 int moneyadd=0;
					m1= inputMoney(moneyadd);
					return m1;
			 }	
	}
	public static void chooseContinue() {
		System.out.println(" you choose ");
		System.out.println("1 is continue buy product");
		System.out.println("2 is end");
		 Scanner sc2 = new Scanner(System.in);
		 int pro2 =sc2.nextInt();
		 if(pro2!=1) {
			 System.out.println("bye ");
			
		 }
		 else {
			 
			 chooseProduct();	
		 }
		
		
	}
	public static void chooseProduct() {
		//int mn=0;
		//int money=inputMoney(mn);
		
		
		 if (money>=min) {
			System.out.print("you chose product");
			System.out.print("  coca =30 ");
			System.out.print("  pepsi =20");
			System.out.print("  cafe =30");
			System.out.print("  milk =20");
			System.out.print("  you chose product");
			// chooseProduct();
			Scanner sc1 = new Scanner(System.in);
			 String pro =sc1.next();
			
			 switch (pro) {
			case "coca":
				if (money>=coca) {
					System.out.println("coca");
					money=money-coca;
					System.out.println(money);
					chooseContinue();
				}
				else {
					chooseContinue();
					int m1=0;
					 money+=addreturnMoney(m1);
					 
				}

				break;
			case "pepsi":
				if (money>=pepsi) {
					System.out.println("pepsi");
					money=money-pepsi;
					System.out.println(money);
					chooseContinue();
				}
				else {
					chooseContinue();
					int m1=0;
					 money+=addreturnMoney(m1);
					 
				}
				break;
			case "cafe":
				if (money>=cafe) {
					System.out.println("cafe");
					money=money-cafe;
					System.out.println(money);
					chooseContinue();
				}
				else {
					chooseContinue();
					int m1=0;
					 money+=addreturnMoney(m1);
					 chooseContinue();
				}
				break;
			case "milk":
				if (money>=milk) {
					System.out.println("milk");
					money=money-milk;
					System.out.println(money);
					chooseContinue();
				}
				else {
					chooseContinue();
					int m1=0;
					 money+=addreturnMoney(m1);
					 chooseContinue();
				}
				break;

			default:
				break;
			} 
			
			
		}
		 else {
			 System.out.println("money < price product , you choose");
				System.out.println(" you choose ");
				System.out.println("1 is add money");
				System.out.println("2 is end");
				 Scanner sc2 = new Scanner(System.in);
				 int pro2 =sc2.nextInt();
				 if(pro2!=1) {
					 System.out.println("bye ");
					
				 }
				 else {
					
							 int moneyadd=0;
								money+= inputMoney(moneyadd);
								chooseProduct();
								
				 }
	 
		 }
		 
		
	}
	

	public static void main(String[] args) {
		int mn=0;
		 money=inputMoney(mn);
		 chooseProduct() ;
			
	/*	
		 */
	}
	

}
