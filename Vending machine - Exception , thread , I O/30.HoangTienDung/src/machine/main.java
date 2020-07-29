package machine;

import java.util.Scanner;

public class main {	
	
	static machine machine1 = new machine(null);

	public static void main(String[] args) {
		subinterface sub = new subinterface();
		System.out.print("Food or Drink ? (1/2 ?)");
		try (Scanner scan = new Scanner(System.in)) {
			int a = scan.nextInt();
			switch(a) {
			case 1:{
				machine1 = new machine(sub.addlist2());
				break;
			}
			case 2:{
				machine1 = new machine(sub.addlist1());
				break;
			}
			}
		}
		
	}

}