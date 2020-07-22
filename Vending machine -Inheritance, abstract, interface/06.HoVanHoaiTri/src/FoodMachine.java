import java.util.Scanner;

public class FoodMachine extends Machines {
	int[] priceProduct = {3, 5, 7, 10 };
	String[] nameProduct = { "Noodle", "Snake", "candy", "Shushi" };
	
	TypeFromKeyboard type = new TypeFromKeyboard();
	
	public void showProduct() {
		 Vending(priceProduct, nameProduct);
	}
}
