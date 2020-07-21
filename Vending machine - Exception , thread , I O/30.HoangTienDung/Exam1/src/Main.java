import java.util.Scanner;

public class Main {
		static subintefacemachine sub = new subintefacemachine();
		
		static int choice =0;
		static Scanner scan = new Scanner(System.in);
		public static void main(String[] args) {
			try {			
			System.out.print("Food or Drink (1 or 2)??");
			choice = scan.nextInt();
			}catch(Exception e) {}
			if(choice == 2) {
			machine machine1 = new machine();
			machine1.machineProduct(sub);
			} else {
				machinefood machine2 = new machinefood();
				machine2.machineProduct(sub);
			}
	}
}
				