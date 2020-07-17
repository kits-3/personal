package example1;

import java.util.Scanner;

public class aaaa {

	public static void main(String[] args) {
		
		int a ;
		int b ;
		double result =0;
		String caculate;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nhap a: ");
		a = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Nhap b: ");
		b = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Caculate: ");
		caculate = scan.nextLine();
		
		scan.close();
		
		switch(caculate) {
			case "+" : result = a +b ;
				break;
			case "-": result = a-b;
				break;
			case "*": result = a*b;
				break;
			case "/": result = a/b;
			 	break;
			case "%": result = a%b;
				break;
			default: 
				break;
		}
			
		System.out.println("------------------------------");
		System.out.printf("%d %s %d = %.2f " ,a,caculate,b,result); 
		
	}

}
