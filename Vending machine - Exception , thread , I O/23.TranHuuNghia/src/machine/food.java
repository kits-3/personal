package machine;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class food extends VendingOperator{
	public food() {}
	
	@Override
	public void showMenu() {
		System.out.println("----------Select Menu-------------");
		System.out.println("1.Rice 100$");
		System.out.println("2.Bread 200$");
		System.out.println("3.Fish 300$");
		System.out.println("4.Hamburger 400$");
		System.out.println("-------------------------------------");
	}
	
	@Override
	public int inputmoney() {
		System.out.println("please input money: ");
		money = sc.nextInt();
		System.out.println("your money : " + money + "$");
		return money; 
	}
	
	@Override
	public int minCost (){
		int minCost =100;
		return minCost;
	}
	@Override
	public String chooseProduct() {
		String product;
		System.out.println("please select product");
		product = sc.next();
		return product;
	}
	
	@Override
	public int addMoney(int money) {
		System.out.println("want more money? please input y or n");
		String checkString = sc.next();
		if(checkString.equals("y")) {
			System.out.print("Plese input money change > 100: ");
			int moneyc = sc.nextInt();
			money += moneyc;
			System.out.println("money change: " + money);
			return money;
		}else {
			System.out.println("good bye and your money: " + money);
			return money;
		}
	}
	
	@Override
	public void Receipt(String receipt) {
		try {
			FileOutputStream fout = new FileOutputStream("D:/Workpace/ReceiptWrite.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			String recp =  receipt + "";
			byte[] b = receipt.getBytes();
			
			
			bout.write(b);    
		    bout.flush();    
		    bout.close();    
		    fout.close(); 
		    System.out.println("Receipt Veding Machine");
		    System.out.println(receipt + "" );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
