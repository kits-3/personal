import java.util.Scanner;

public class While_Example {

	public static void for_example() {
		Scanner sc =new Scanner(System.in);
		String a = sc.next();
		System.out.println("input = " + a);

		if (a.equals("start")) {

			for (int i = 10; i > 0; i--) {
				System.out.println("count: "+i);
				if(i==1) {
					System.out.println("launch");
				}

			}

		}
		
		
	}
	
	
	public static void main(String[] args) {
	
		for_example();
		
	}
	
}
