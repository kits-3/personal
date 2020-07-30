import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		IMachine aMachine = new AMachine();
		IMachine bMachine = new BMachine();
		IMachine cMachine = new CMachine();
		

		System.out.println("Please select machine:1.Machine drink 2.Machine food 3.Machine study");
		Scanner scan = new Scanner(System.in);
		int selectMachine = scan.nextInt();
		if(selectMachine == 1) {
		IMachine[] iMachines  = { aMachine};
		for(int i = 0; i < iMachines.length; i++) {
			iMachines[i].inputMoney();
			iMachines[i].selectProduct();
		}
		}
		if(selectMachine == 2) {
			IMachine[] iMachines  = { bMachine};
			for(int i = 0; i < iMachines.length; i++) {
				iMachines[i].inputMoney();
				iMachines[i].selectProduct();
			}
			}
		if(selectMachine == 3) {
			IMachine[] iMachines  = { cMachine};
			for(int i = 0; i < iMachines.length; i++) {
				iMachines[i].inputMoney();
				iMachines[i].selectProduct();
			}
			}
	}
}
