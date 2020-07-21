package star;
import java.util.*;
public class star {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		for (int i = 0; i < number; i++ ) {
			
			for (int j = 1; j < number - i ; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i*2 + 1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
