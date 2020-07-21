import java.util.Scanner;

public class main{
	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose machine");
		int key = scanner.nextInt();
		switch (key) {
		case 1:
			System.out.println("You choose machine 1");
			new check(100, 200, 300, "Coca", "Pepsi", "Orang");
			break;
		case 2:
			System.out.println("You choose machine 2");
			new check(500, 600, 700, "Chuoi", "Buoi", "Cam");
			break;
		case 3:
			System.out.println("You choose machine 3");
			new check(1200, 1400, 1800, "Lenovo", "Asus", "Dell");
			break;
		default:
			break;
		}

	}

}
