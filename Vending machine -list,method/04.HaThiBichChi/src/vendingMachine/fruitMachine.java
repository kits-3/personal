package vendingMachine;

import java.util.ArrayList;

public class fruitMachine extends Machine implements IFunction {
	

	@Override
	public void showProduct() {
		// TODO Auto-generated method stub
		for (int i = 0; i < fruit.length; i++) {
			System.out.println("product: " + fruit[i] + "(" + 10 * ++i + "VND" +  ")");
			i--;
		}
	}
	@Override
	public ArrayList<String> selectProduct(String product, ArrayList<String> products) {
		// TODO Auto-generated method stub
		return products;
	}
	
	@Override
	public int handleMoney(ArrayList<String> products, int money, int moneyStart) {
		moneyStart = money;
		for (int i = 0; i < products.size(); i++) {
			for (int j = 0; j < fruit.length; j++) {
				if(fruit[j].equalsIgnoreCase(products.get(i))) {
					if(fruit[j].equalsIgnoreCase("chomchom")) {
						money -= chomchom;
					}else if(fruit[j].equalsIgnoreCase("saurieng")) {
						money -= saurieng;
					}else if(fruit[j].equalsIgnoreCase("vai")) {
						money -= vai;
					}else if(fruit[j].equalsIgnoreCase("nhan")) {
						money -= nhan;
					}
					
				};
			}
		}
		products.remove(products.size() - 1);
		if(money < 0) {
			System.out.println("you push money");
		}
		return money;
	}
}
