package vendingMachine;

import java.util.Scanner;

public interface IFunction {
	
	int inputMoney(int money,boolean isNumber, Scanner sc);
	
	int selectProduct();
	int handleMoney();
}
