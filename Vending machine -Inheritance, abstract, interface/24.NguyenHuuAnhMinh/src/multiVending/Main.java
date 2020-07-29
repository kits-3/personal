package multiVending;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money=0;
		int moneyLeft =0;
		int vendingType = 0;
		boolean checkMore =true;
		String[] product = {"Beer","Juice","Milk","Omachi","Aone","Myone","Type1","Type2","Type3"}; 
		int[] productPrice = {600,800,1000,800,400,700,3000,4500,2000};
		vending waterVd = new WaterVendingMachine();
		vending noodleVd = new NoodleVendingMachine();
		vending figureVd = new FigureVendingMachine();
		
		System.out.println("Please choose type of vending machine, 1,2 or 3");
		System.out.println("1.Drink Vending Machine");
		System.out.println("2.Noodle Vending Machine");
		System.out.println("3.Figure Vending Machine");
		System.out.println("-----------------------------------------------");
		Scanner sc = new Scanner(System.in);
		vendingType = sc.nextInt();
		
		
		if(vendingType==1){
			System.out.println("Welcome to Drink Vending Machine");
			money += waterVd.inputMoney();
			while(checkMore==true){
				if(waterVd.checkMoney(money)==true){
					waterVd.showMenu();
					String productName = waterVd.inputProductName();
					System.out.println(productName);
					for(int i = 0 ; i < product.length ; i++){
						if(productName.equals(product[i])){
							money = money - productPrice[i];
							System.out.println("Buying successfull !!");
							System.out.println("You have " + money + "$ left");
						}
					}
					checkMore = waterVd.checkMore();
				}else{
					if(waterVd.checkMore() == false){
						checkMore = false;
					}else{
						System.out.println("Insert more money to buy(Min product price: 600$) ,You now have: "+money);
						money += waterVd.inputMoney();
					}
				}
			}	
		}else if(vendingType==2){
			System.out.println("Welcome to Noodles Vending Machine");
			money += noodleVd.inputMoney();
			while(checkMore==true){
				if(noodleVd.checkMoney(money)==true){
					noodleVd.showMenu();
					String productName = noodleVd.inputProductName();
					System.out.println(productName);
					for(int i = 0 ; i < product.length ; i++){
						if(productName.equals(product[i])){
							money = money - productPrice[i];
							System.out.println("Buying successfull !!");
							System.out.println("You have " + money + "$ left");
						}
					}
					checkMore = noodleVd.checkMore();
				}else{
					if(noodleVd.checkMore() == false){
						checkMore = false;
					}else{
						System.out.println("Insert more money to buy(Min product price: 400$) ,You now have: "+money);
						money += waterVd.inputMoney();
					}
				}
			}	
		}else if(vendingType==3){
			System.out.println("Welcome to Figure Vending Machine");
			money += figureVd.inputMoney();
			while(checkMore==true){
				if(figureVd.checkMoney(money)==true){
					figureVd.showMenu();
					String productName = figureVd.inputProductName();
					System.out.println(productName);
					for(int i = 0 ; i < product.length ; i++){
						if(productName.equals(product[i])){
							money = money - productPrice[i];
							System.out.println("Buying successfull !!");
							System.out.println("You have " + money + "$ left");
						}
					}
					checkMore = figureVd.checkMore();
				}else{
					if(figureVd.checkMore() == false){
						checkMore = false;
					}else{
						System.out.println("Insert more money to buy(Min product price: 2000$) ,You now have: "+money);
						money += waterVd.inputMoney();
					}
				}
			}	
		}
		
	}

}
