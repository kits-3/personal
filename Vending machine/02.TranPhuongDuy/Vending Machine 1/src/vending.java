import java.util.Scanner;

public class vending {

	public static void main(String[] args) {
		int OGKush = 0;
		int Ketamin = 20;
		int Mushroom = 30;
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please insert the money");
		while (true) {
			if(OGKush == 0 && Ketamin == 0 && Mushroom ==0 ) {
				System.out.print("out of stock, choose something else for get high");
				break;
			}
		System.out.println("Select Your Highly Product");
		System.out.println("1. OGKush");
		System.out.println("2.Ketamin");
		System.out.println("3.Mushroom");
		System.out.println("Your choice:");
		
		int YourChoice = scanner.nextInt();
		if(YourChoice == 1 && OGKush > 0 ) {
			System.out.println("You Chose OGKush");
		} else if(YourChoice==1 && OGKush ==0){
			System.out.println("The product is out of stock, please choose other");
			
		}
		if(YourChoice == 2 && Ketamin > 0) {
			System.out.println("You Chose Ketamin");
		}else if(YourChoice==1 && Ketamin ==0){
			System.out.print("The product is out of stock, please choose other");
			
		}
		if(YourChoice == 3 && Mushroom > 0) {
			System.out.println("You Chose Ketamin");
		}else if(YourChoice==1 && Mushroom ==0){
			System.out.print("The product is out of stock, please choose other");
			
		}
		int Prize = 25;
		            System.out.print("Please insert " + Prize + " $ :");
		            int Coins = scanner.nextInt();
		            while (Coins < Prize) {
		                System.out.println("Please insert the remaining "+ (Prize - Coins) + " $ :");
		                Coins += scanner.nextInt();
		            }
		            if (Coins == Prize) {
		                System.out.println("Thank you, please take your highlydagreen.");
		            }
		            else if (Coins > 25) {
		                System.out.println("Thank you, please take your change ("+ (Coins - 25) + " $), and your highlydagreen.");
		            }
		            else if (Coins < 0) {
		                System.out.println("Please insert a valid amount");
		            }
		            System.out.println("");
		            System.out.println("-------Welcome to the CANABIS Vending Machine-------");
		}
	}
}
