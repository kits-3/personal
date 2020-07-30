import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		int option = 0;
		Machine machine = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Machine One");
		System.out.println("2. Machine Two");
		System.out.println("3. Machine Three");
		System.out.print("Select Machine: ");
		option = scanner.nextInt();
		switch (option) {
		case 1:
			machine = new MachineOne();
			System.out.println("======MACHINE ONE START======");
			break;
		case 2:
			machine = new MachineTwo();
			System.out.println("======MACHINE TWO START======");
			break;
		case 3:
			machine = new MachineThree();
			System.out.println("======MACHINE THREE START======");
			break;
		}
		
		machine.sellProduct();
	}
}
