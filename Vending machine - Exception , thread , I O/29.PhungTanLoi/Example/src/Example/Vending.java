package Example;

import java.util.ArrayList;

public interface Vending {
	public int getLowestMoney(int money);
	public ArrayList<Drink> getList();
	public ArrayList<Food> getList1();
	public void displayList();
	public void displayList1();
	public int selectProduct(int money, int num);
	public int selectProduct1(int money, int num);
	public void returnMoney();
	public void outPut();
	
}
