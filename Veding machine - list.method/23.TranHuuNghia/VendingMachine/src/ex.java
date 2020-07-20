import java.util.Scanner;

public class ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double product = 0;
		double MinCos = 4;
		int input = 0;
		
		
		System.out.print("input money: ");
		double money = sc.nextDouble();
		int menu = 1;
		do
		{
				while (menu != 0)
				{
					System.out.println("-----------Menu----------------");
					System.out.println("1.Coca 6$");
					System.out.println("2.Sprite 9$ ");
					System.out.println("3.Fanta 8$");
					System.out.println("4.Pepsi 4$");
					System.out.println("0.Finish ");
					System.out.println("Plese choose: (0,1,2,3,4)");
					menu = sc.nextInt();
						
						switch (menu){
							case 1:
								product += 6;
								break;
							case 2:
								product += 9;
								break;
							case 3:
								product += 8;
								break;
							case 4:
								product += 4;
								break;
							case 0:
								System.out.println("complete");
								break;
							default:
								System.out.println("Input wrong menu");
								break;
						}
		
						if (money >= MinCos)
						{
							if (money >= product)
							{
								if (money == product)
								{
									System.out.println("Get Product of Menu: " + menu);
								}
								else
								{
									money = money - product;
									System.out.println("Get Product of Menu" + menu + " and money: " + money + "$");
								}
							}
						}
						else	
						{
							
							product = 0;
							
							double change;
							System.out.println("You haven't enough money.");
							System.out.println("Do you want to add a little money  ?");
							System.out.println("1. Yes, 2. No");
							input = sc.nextInt();
							switch (input) {
								
							case 1:
								System.out.print("Input change: ");
								change = sc.nextDouble();
								money += change;
								System.out.println("Your money: " + money + "$");
								break;
							case 2:
								System.out.println("Your money: " + money + "$  bye bye");
								break;
							
							default:
								System.out.println("Input Wron");
								break;
							
							}
						}
		
				}
		}while (input != 0);

	}
}

