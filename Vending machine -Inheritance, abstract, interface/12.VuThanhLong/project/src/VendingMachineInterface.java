import java.util.List;

public interface VendingMachineInterface {
	boolean isContinue(int money);
	List<Product> chooseMachine(int choose);
	void showMachine();
	void showProduct(List<Product> listProduct);
	int minPrice(List<Product> listProduct);
}
