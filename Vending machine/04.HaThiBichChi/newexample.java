package VendingMachine;

import java.util.Scanner;

public class newexample {
	static int money =0;
	public static void main(String[] args) {
	
		String proA ="coca";
		String proB="juice";
		String proC="soju";
		
		int aPrice=100;

		int bPrice=100;

		int cPrice=100;
		
		boolean checkMoney =true;
		boolean checkMore =true;
		
		Scanner scan = new Scanner (System.in);
		
		while(checkMore) {
		System.out.print("please input money:");
		money = scan.nextInt();
		if( money < aPrice || money < bPrice || money < cPrice)
		{
			System.out.print("want more? please input y or n");
			String checkString = scan.next();
			if(checkString.equals("y"))
			{
				
			}
			else {
				System.out.println("good bye");
				checkMore = false; 
			}
		}
			else {
				while(checkMore) {
					System.out.print("select product: 1."+proA+"("+aPrice+")\n2."+proB+"("+bPrice+")\n3."+proC+"("+cPrice+")");
					String selectProduct = scan.next();
					if(selectProduct.equals(proA) )
					{
						if(aPrice > money) {
							checkMore = true;
							return;
						}
						money -=aPrice;
						
					}
					else if(selectProduct.equals(proB))
					{
						if(bPrice > money) {
							checkMore = true;
							return;
						}
						money -=bPrice;
					}
					else if(selectProduct.equals(proC))
					{
						if(cPrice > money) {
							checkMore = true;     
							return;
						}
						money -=cPrice;
					}
					
					System.out.print("want more select product> y or n?");
					scan.next();
					String checkString = scan.next();
					if(checkString.equals("y"))
					{
						
					}
					else {
						System.out.println("your change: "+money+ "good bye");
						checkMore = false; 
					}
				}
			
				
				
			}
			
			
		}
		
		
		
	}


}
