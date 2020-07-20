package Example;

import java.util.ArrayList;
import Example.VendingMachine;
import Example.Drink;
public class Main {
	static int money = 0;
	public static void main(String[] args)
	{
		VendingMachine vendingMachine = new VendingMachine();
		ArrayList<Drink> List = new ArrayList<Drink>();
		List = vendingMachine.getList();
		vendingMachine.displayList();
		
	}
}
