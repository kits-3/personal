
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//		public static boolean soSanh(String i,String j)
//		{
//			if(i==j)
//			{
//				return true;
//			}
//			else return false;
//		}

		public static void main(String[] args) {
			int Price =0;
			
			Scanner scan = new Scanner(System.in);
			
			boolean checkMore = true;
			ArrayList<String> arrayName = new ArrayList<String>();
			arrayName.add("Coca");
			arrayName.add("Pepsi");
			arrayName.add("Milk");
			ArrayList<Integer> arrayPrice = new ArrayList<Integer>();
			arrayPrice.add(10000);
			arrayPrice.add(15000);
			arrayPrice.add(20000);
			
			do 
			{
				while(Price<10000)
				{
					System.out.println("Your Price: "+Price);
					System.out.println("Input money: ");
					Price = scan.nextInt()+Price;
				}
				if(Price>=10000)
				{
					System.out.println("Input select product: \n1-"+arrayName.get(0)+"-"+arrayPrice.get(0)+"\n2-"+arrayName.get(1)+"-"+arrayPrice.get(1)+"\n3-"+arrayName.get(2)+"-"+arrayPrice.get(2));
					int b = scan.nextInt();
					if(Price>=arrayPrice.get(b-1))
					{						
						Price = Price-arrayPrice.get(b-1);
						System.out.println("Your Price: "+Price);
						System.out.println("Are you buy? (Y/N?)");
						String c = scan.next();
						if(c.equalsIgnoreCase("n"))
						{
							checkMore = false;
						}
						else if(c.equalsIgnoreCase("y"))
						{
							checkMore = true;
						}
						else
						{
							System.out.println("Input faild !");
							checkMore = true;
						}
					}
				}
			}while(checkMore);
			System.out.println("Good bye !");
			scan.close();
	}
}
				