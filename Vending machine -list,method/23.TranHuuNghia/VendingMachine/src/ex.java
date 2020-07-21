import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.LeafElement;

public class ex {

	static Scanner sc = new Scanner(System.in);
	static List<String> product = new ArrayList();
	static List<Double> price = new ArrayList();
	
	public static double inputmoney(){
		double money;
		System.out.println("Input Money");
		money = sc.nextDouble();
		System.out.println("Your Money: " + money);
		return money;
	}
	public static double minCostProduct (){
		double minCost = price.get(0);
		for (int i = 0; i < price.size(); i++)
		{
			if (minCost >= price.get(i))
				minCost = price.get(i);
		}
		return minCost;
	}
	public static boolean checkMoney(double money, double minCost){
		boolean check = false;
		if (money > minCost || money == minCost)
			check = true;
		return check;
	}
//-------------main----------------
	
	
	public static void main(String[] args) {
		double money = 0.0;
		double minCost = 0.0;
		product.add("coca");
		product.add("milk");
		product.add("coki");
		product.add("juice");
			
		price.add(600.0);
		price.add(400.0);
		price.add(900.0);
		price.add(100.0);
		
		money = inputmoney();
		minCost = minCostProduct();
		if (checkMoney(money, minCost))
		{
			
		}
		else
		{
			System.out.println("Your money: " + money);
		}
		
	}
	
	
//---------main----------------------------
}

