import java.util.Scanner;

public class TypeFromKeyboard {
	public int typeKeyboard() {
		Scanner scanner = new Scanner(System.in);
		int numberProduct;
		
		System.out.println("\nWould you like to buy ?");

		System.out.print("Select a number on keyboard: ");
		numberProduct = scanner.nextInt();
		
		return numberProduct;
	}
}
