package vendingMachine;


public class VendingMachine extends Machine implements IFunction{
	@Override
	public void showProduct() {
		// TODO Auto-generated method stub
		for (int i = 0; i < vending.length; i++) {
			System.out.println("product: " + vending[i] + "(" + 10 * ++i + "VND" +  ")");
			i--;
		}
	}
	
}
