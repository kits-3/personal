import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	static int money = 0;
	static List<String> productNameList = new ArrayList<String>();
	static List<Integer> productPriceList = new ArrayList<Integer>();
	
	public static boolean checkEnoughMoney(String selectedProduct){
		for(int i=0; i < productNameList.size(); ++i){
			if(selectedProduct.equals(productNameList.get(i))){
				if(productPriceList.get(i) > money){
					return false;
				}
				System.out.println("your select: " + productNameList.get(i));
				money -= productPriceList.get(i);
			}
		}
		return true;
	}
		
	public static void main(String[] args) {
		productNameList.add("coke");
		productNameList.add("juice");
		productNameList.add("milk");
		
		productPriceList.add(100);
		productPriceList.add(200);
		productPriceList.add(300);
		
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
					if(checkEnoughMoney(selectedProduct)== false){
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

}
