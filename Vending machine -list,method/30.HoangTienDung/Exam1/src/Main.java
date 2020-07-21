
import java.util.Scanner;

public class Main {

		static subintefacemachine subinterfacemachine = new subintefacemachine();
		public static void main(String[] args) {
			int Price =0;
			String note = "";
			Scanner scan = new Scanner(System.in);
			
			boolean checkMore = true;
		
			System.out.println("product :");
			
			subinterfacemachine.addDrink();
			
			subinterfacemachine.getDrink();
			do 
			{
				while(Price<subinterfacemachine.minDrink())
				{
					System.out.println("Your Price: "+Price);
					System.out.println("Input money: ");
					Price = scan.nextInt()+Price;
				}
				if(Price>=subinterfacemachine.minDrink())
				{					
					subinterfacemachine.getDrink();
					System.out.print("Input product :");
					int b = scan.nextInt();
					if(Price>=subinterfacemachine.listDrink.get(b-1).getPrice())
					{						
						Price = Price-subinterfacemachine.listDrink.get(b-1).getPrice();
						System.out.println("Your had "+subinterfacemachine.listDrink.get(b-1).getPrice());
						System.out.println("Your Price: "+Price);
						note = note+"Your had "+subinterfacemachine.listDrink.get(b-1).getPrice()+"Input product :"+b+"Your Price: "+Price+"\n";
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
			subinterfacemachine.output(note);
			scan.close();
	}
}
				