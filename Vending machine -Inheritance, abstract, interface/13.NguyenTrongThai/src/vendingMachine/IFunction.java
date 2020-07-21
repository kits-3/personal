package vendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public interface IFunction {
	
	int chomchom = 10;
	int saurieng = 20;
	int vai = 30;
	int nhan = 40;
	int cai = 10;
	int carot = 20;
	int bingo = 30;
	int rauxanh = 40;
	int xiting = 10;
	int milk = 20;
	int coca = 30;
	int pessi = 40;
	
	String[] fruit = {"chomchom", "saurieng", "vai", "nhan"};
	String[] vegetable = {"cai", "carot", "bingo", "rauxanh"};
	String[] vending = {"xiting", "milk", "coca", "pessi"};
	String[] machine = {"fruit", "vegetable", "vending"};
	
	
	int selectName(Scanner sc, int machine, boolean isSl);
	int inputMoney(int money,boolean isNumber, Scanner sc);
	
	void showProduct();
	ArrayList<String> selectProduct(String product, ArrayList<String> products);
	int handleMoney(ArrayList<String> products, int money, int moneyStart);
}
