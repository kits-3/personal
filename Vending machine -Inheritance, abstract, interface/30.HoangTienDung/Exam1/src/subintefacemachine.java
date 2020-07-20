import java.util.ArrayList;
import java.util.List;

public class subintefacemachine implements interfacemachine{
	List<Drink> listDrink = new ArrayList<Drink>();
	List<Foot> listFood = new ArrayList<Foot>();
	@Override
	public List<Drink> addDrink() {
		// TODO Auto-generated method stub
		listDrink.add(new Drink("Pepsi",10000));
		listDrink.add(new Drink("Coca",10000));
		listDrink.add(new Drink("Milk",10000));
		return listDrink;
	}
	@Override
	public List<Foot> addFood() {
		// TODO Auto-generated method stub
		listFood.add(new Foot("Pizza",30000));
		listFood.add(new Foot("Hot Dog",20000));
		listFood.add(new Foot("Hamboger",15000));
		return listFood;
	}
	@Override
	public void getDrink() {
		// TODO Auto-generated method stub
		for(int i=0;i<listDrink.size();i++) {
			System.out.println(listDrink.get(i).getName()+"-"+listDrink.get(i).getPrice());
		}
	}
	@Override
	public void getFood() {
		// TODO Auto-generated method stub
		for(int i=0;i<listFood.size();i++) {
			System.out.println(listFood.get(i).getName()+"-"+listFood.get(i).getPrice());
		}
	}
	@Override
	public int minDrink() {
		// TODO Auto-generated method stub
		int min = listDrink.get(0).getPrice();
		for(int i=0;i<listDrink.size();i++) {
			if(min>listDrink.get(i).getPrice()) {
				min=listDrink.get(i).getPrice();
			}
		}
		return min;
	}
	@Override
	public int minFood() {
		// TODO Auto-generated method stub
		int min = listFood.get(0).getPrice();
		for(int i=0;i<listFood.size();i++) {
			if(min>listFood.get(i).getPrice()) {
				min=listFood.get(i).getPrice();
			}
		}
		return min;
	}

}
