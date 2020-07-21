import java.util.Scanner;

public class Example_method {

	public static void main(String[] args) {
		while (true) {
			Scanner sc=new Scanner(System.in);
			
			int money=inputMoney(0);
			String drink = "";
			
			if (money > 100) {
				System.out.println("select drink");
				drink = sc.next();

			} else {
				System.out.println("drink: " + drink);
				inputMoney(money);
			}
			
			System.out.println("drink " + drink);

		}
		
	}
	/////////////////////////////  88 //////////////////////////////////////////////////
	public static int inputMoney(int money) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input money");
		int inputMoney = sc.nextInt();
		
		money+=inputMoney(money);
		
		return money;
	}

}

