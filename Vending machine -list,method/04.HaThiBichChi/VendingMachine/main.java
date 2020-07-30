package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class main {
	public static void main(String[] args) {
		System.out.println("Welcome to my store");
		System.out.println("Choose type machine");
		System.out.println("1.Machine 1\n2.Machine 2\n3.Machine 3");
		Scanner sc = new Scanner(System.in);
		int input=sc.nextInt();
		
		
	
	
		switch (input) {
		case 1:
			machine1 mc = new machine1();
		
		case 2:
			machine2 mc2 = new machine2();
			mc2.built();
			
		
		case 3: 
			machine3 mc3 = new machine3();
			mc3.built();
		
	}
}
}
