package multiVending;
import java.util.Scanner;

public abstract class vending {
	public abstract int inputMoney();
	public abstract String inputProductName();
	public abstract void showMenu();
	public abstract boolean checkMore();
	public abstract boolean checkMoney(int money);
}
