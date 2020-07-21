
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class subintefacemachine implements interfacemachine{
	List<Drink> listDrink = new ArrayList<Drink>();
	List<Food> listFood = new ArrayList<Food>();
	public FileWriter writer;
	@Override
	public List<Drink> addDrink() {
		// TODO Auto-generated method stub
		listDrink.add(new Drink("Pepsi",10000));
		listDrink.add(new Drink("Coca",10000));
		listDrink.add(new Drink("Milk",15000));
		return listDrink;
	}
	@Override
	public List<Food> addFood() {
		// TODO Auto-generated method stub
		listFood.add(new Food("Pizza",30000));
		listFood.add(new Food("Hot Dog",20000));
		listFood.add(new Food("Hamboger",15000));
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
	@Override
	public void output(String bytes) {
		// TODO Auto-generated method stub
		try {
			String fileDir = "C:/Users/PC30/Desktop/team_5/personal/Vending machine -Inheritance, abstract, interface/30.HoangTienDung/Exam1/vendingmachinenote.txt";
			writer = new FileWriter(fileDir);
			writer.write(bytes+"\n");
			writer.close();
		}catch(Exception e) {
			
		}
	}

}
