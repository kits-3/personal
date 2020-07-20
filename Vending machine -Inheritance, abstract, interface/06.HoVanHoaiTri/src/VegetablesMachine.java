
public class VegetablesMachine extends Machines{
	int[] priceProduct = {3, 5, 7, 10 };
	String[] nameProduct = { "Tomato", "Cucumber", "Cabbage", "Mushroom" };
	
	TypeFromKeyboard type = new TypeFromKeyboard();
	
	public void showProduct() {
		 Vending(priceProduct, nameProduct);
	}
}
