import java.util.Scanner;

public class DrinkMachine extends Machines{
	int[] priceProduct = {3, 5, 7, 10 };
	String[] nameProduct = { "Pepsi", "Coca", "Orange", "Apple" };
	
	TypeFromKeyboard type = new TypeFromKeyboard();
	
	public void showProduct() {
		 Vending(priceProduct, nameProduct);
	}
	

}
