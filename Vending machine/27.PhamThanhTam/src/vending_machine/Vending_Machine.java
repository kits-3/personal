package vending_machine;
import java.util.*;
public class Vending_Machine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String end = "";
		System.out.println("input money: ");
		int money = scanner.nextInt();
		while (!end.equals("END")) {
			int minMoney = 10, moneyCurrent = 0, producPrice =0, moreMoney=0 ;
			
			if (money >= minMoney) {
				System.out.println("product price, what you you want yo buy: ");
				producPrice = scanner.nextInt();
				if (money>=producPrice) {
					moneyCurrent = money - producPrice;
					System.out.println("product price you buy: " + producPrice);
					System.out.println("change: " + moneyCurrent);
				}
				else {
					System.out.println("money < product price min is 10$");
				}
			}else {
				System.out.println("money < product price min '10$' ");
			}
			System.out.println("do you want to add more money? 'YES' or 'NO' ");
			String checkMoreMoney = scanner.next();
			if (checkMoreMoney.equals("NO")) {
				System.out.println("thanks you and end order");
				if (moneyCurrent != 0) {
					System.out.println("change = " + moneyCurrent);
				}
				end = "END";
				
			} else {
				if (checkMoreMoney.equals("YES") ) {
					if (moneyCurrent < minMoney || moneyCurrent < producPrice) {
						System.out.println("input more money");
						moreMoney = scanner.nextInt();
						money = moreMoney +moneyCurrent;
					}else {
						money = moneyCurrent;
					}
					
				}
			}
			
		}
		
	}

}