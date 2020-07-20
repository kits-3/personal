package Example;

import java.awt.List;
import java.util.ArrayList;

public class VendingMachine implements Vending {
	ArrayList<Drink> List = new ArrayList<Drink>();
	@Override
	public ArrayList<Drink> getList() {
		// TODO Auto-generated method stub
		List.add(new Drink("coca",1000));
		List.add(new Drink("pepsi",2000));
		List.add(new Drink("soda",3000));
		return List;
		
	}

	@Override
	public void displayList() {
		// TODO Auto-generated method stub
		for (int i = 0; i < List.size(); i++) {
			System.out.println("Name:"+List.get(i).getName()+" Price:"+List.get(i).getPrice());
		}
	}

	@Override
	public void selectProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnMoney() {
		// TODO Auto-generated method stub
		
	}
	
}
