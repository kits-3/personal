import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class machine {
	
	public void machineProduct(subintefacemachine a) {
		int Price =0;
		String note = "";
		Scanner scan = new Scanner(System.in);
		
		boolean checkMore = true;
	
		System.out.println("product :");
		
		a.addDrink();
		
		a.getDrink();
		do 
		{
			while(Price<a.minDrink())
			{
				System.out.println("Your Price: "+Price);
				System.out.println("Input money: ");
				Price = scan.nextInt()+Price;
			}
			if(Price>=a.minDrink())
			{					
				a.getDrink();
				System.out.print("Input product :");
				int b = scan.nextInt();
				if(Price>=a.listDrink.get(b-1).getPrice())
				{						
					Price = Price-a.listDrink.get(b-1).getPrice();
					System.out.println("Your had "+a.listDrink.get(b-1).getPrice());
					System.out.println("Your Price: "+Price);
					note = note+"Your had "+a.listDrink.get(b-1).getPrice()+"Input product :"+b+"Your Price: "+Price+"\n";
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
		System.out.println("Your exchange: "+Price);
		System.out.println("Thank you!\nGood bye !");
		note = note + "Thank you!\nGood bye !";
		a.output(note);
		scan.close();
	}
}
