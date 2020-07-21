import java.util.List;

public interface interfacemachine {
	
	public List<Drink> addDrink();
	public List<Food> addFood();
	public void getDrink();
	public void getFood();
	public int minDrink();
	public int minFood();
	public void output(String bytes);
}
