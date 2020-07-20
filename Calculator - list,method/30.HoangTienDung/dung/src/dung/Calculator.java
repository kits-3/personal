package dung;

import java.util.Scanner;

public class Calculator {
	public static void main(String [] args) {
		int a=0;
		
		boolean checkMore = true;
		Scanner scan = new Scanner(System.in);
		System.out.print("please input number: ");
		a = scan.nextInt();
		do {
			System.out.print("please input operator: ");
			String b = scan.next();
			if(b.equalsIgnoreCase("+")||b.equalsIgnoreCase("-")||b.equalsIgnoreCase("*")||b.equalsIgnoreCase("/")) {
				System.out.print("please input number: ");
				int c = scan.nextInt();
				switch(b){
					case "+":{
						a += c;
						System.out.println("="+a);
						break;
					}
					case "-":{
						a -= c;
						System.out.println("="+a);
						break;
					}
					case "*":{
						a *= c;
						System.out.println("="+a);
						break;
					}
					case "/":{
						a /= c;
						System.out.println("="+a);
						break;
					}
				}
			}
			else if(b.equalsIgnoreCase("=")) {
				checkMore = false;
			}
		}while(checkMore);
		System.out.print("end ="+a);
		scan.close();
	}
}
