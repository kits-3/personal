import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		DrinkMachine drink = new DrinkMachine();
		FoodMachine  food = new FoodMachine();
		VegetablesMachine ve = new VegetablesMachine();
		
		int numberMachine;
		
		do {
		System.out.println("Select type of machine");
		System.out.println("1. DrinkMachine \t 2. FoodMachine \t 3. VegetablesMachine");
		System.out.print("Type: ");
		numberMachine = scanner.nextInt();
		}
		while(numberMachine < 1 || numberMachine > 3);
		
		if(numberMachine == 1) {
			drink.showProduct();
		}
		if(numberMachine == 2) {
			food.showProduct();
		}
		if(numberMachine == 3) {
			ve.showProduct();
		}
	}

}
