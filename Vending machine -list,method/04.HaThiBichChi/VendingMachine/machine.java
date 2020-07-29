package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class machine {
	public machine() {}
	static int money = 0;
	public List<String> productNameList = new ArrayList();
	public List<Integer> productPriceList = new ArrayList();

	

		
	public void built() {
	
		
		boolean checkMoney = true;
		boolean checkMore = true;
		
		Scanner scan = new Scanner(System.in);
		
		while(checkMore){
			System.out.print("Please input money: ");
			money += scan.nextInt();
			System.out.println("Check your total money: " + money);
			if(money < productPriceList.get(0) && money < productPriceList.get(1) && money < productPriceList.get(2)){
				System.out.print("Want more? Please input y or n: ");
				String checkString = scan.next();
				if(checkString.equals("y")){
					
				}else{
					System.out.println("GOOD BYE");
					checkMore = false;
				}
			}else{
				while(checkMore){
					System.out.println("Please select product 1." 
														+productNameList.get(0)+"("+productPriceList.get(0)
														+")\t2."+productNameList.get(1)+"("+productPriceList.get(1)
														+")\t3."+productNameList.get(2)+"("+productPriceList.get(2)+")");
					String selectedProduct = scan.next();
					if(checkMoney== false){
						checkMore = true;
						break;
					}
					System.out.print("Want more select product (Y/N)? ");
					String checkMoreString = scan.next();
					if(checkMoreString.equals("Y")){
						
					}else{
						System.out.println("Your change: " + money + ". GOOD BYE");
						checkMore = false;
					}
				}
			}
		}
		
	}




	private boolean checkEnoughMoney(String selectedProduct) {
		// TODO Auto-generated method stub
		return false;
	}

}