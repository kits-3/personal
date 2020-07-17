package baitap3;

import java.util.Scanner;

public class kiemtra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] priceproduct = {24, 44, 64, 84};
		String[] nameproduct = { "pessi",  "cocacola", "apple","Orange" };
		int numberproduct;		
		float money, monyreturn;
		System.out.println("what would you like to drink?"); 
		for (int i = 0; i < priceproduct.length; i++) {
			System.out.print(i + 1 + "." + nameproduct[i] + ": " + priceproduct[i] + "$" + "\t");
		}
		
		System.out.print("\r\n" + 
				"choose product: ");
		numberproduct = scanner.nextInt();
		System.out.println("Your choose: " + numberproduct + "." + nameproduct[numberproduct - 1]+" "+ priceproduct[numberproduct-1]+"$");
		System.out.print("Enter money please $: ");
		money = scanner.nextFloat();
		
		while(money < priceproduct[numberproduct - 1]){
			System.out.print("Extra money: ");
			money = scanner.nextFloat();
		
		} 
		System.out.println("Enjoy your drink");
		monyreturn = money - priceproduct[numberproduct - 1];
		int k = 0;
	}
}