package vendingMachine;

public class vegetableMachine extends Machine implements IFunction{
	@Override
	public void showProduct() {
		// TODO Auto-generated method stub
		for (int i = 0; i < vegetable.length; i++) {
			System.out.println("product: " + vegetable[i] + "(" + 10 * ++i + "VND" +  ")");
			i--;
		}
	}
}
