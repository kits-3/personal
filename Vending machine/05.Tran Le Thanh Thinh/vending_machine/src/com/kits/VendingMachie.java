package com.kits;

import java.util.Scanner;

public class VendingMachie {
	public static void main(String[] args) {

		int minCost = 500;
		int currentMoney = 0;
		int pricePesi = 600;
		int priceCoca = 500;
		int price7up = 400;
		boolean flag = true;
		boolean opption = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, insert the money");
		int inputMoney = sc.nextInt();
		while (flag) {
			if (inputMoney <= minCost) {
				currentMoney += inputMoney;
				while (currentMoney < minCost) {
					System.out.println("this is current money : " + currentMoney);
					System.out.println("you do not have enough money to buy the product");
					System.out.println("Please, insert the money more");
					int moneyMore = sc.nextInt();
					currentMoney += moneyMore;
					System.out.println("this is current money " + currentMoney);
				}
//				System.out.println("affter out loop "+currentMoney);
				while(opption){
					System.out.println("menu" + currentMoney);
					System.out.println("Please choose the case 1 2 3 :");
					System.out.println("1.Pesi : 600 ");
					System.out.println("2.Coca : 500 ");
					System.out.println("3.7up : 400 ");
					int item = sc.nextInt();
					switch (item) {
					case 1:
						
						if (currentMoney < pricePesi) {
							while (currentMoney <= pricePesi) {
								System.out.println("Pepsi costs   : " + pricePesi);
								System.out.println("this is current : " + currentMoney);
								System.out.println("you do not have enough money to buy the product");
								System.out.println("Please, insert the money more");
								int moneyMore = sc.nextInt();
								currentMoney += moneyMore;
								System.out.println("this is current money " + currentMoney);
								System.out.println("you can buy it right now !");		
							}
					
						}
						opption = false;
						currentMoney -= pricePesi;
						
						break;
					case 2:
						
						if (currentMoney < priceCoca) {
							while (currentMoney <= priceCoca) {
								System.out.println("Coca costs   : " + priceCoca);
								System.out.println("this is current : " + currentMoney);
								System.out.println("you do not have enough money to buy the product");
								System.out.println("Please, insert the money more");
								int moneyMore = sc.nextInt();
								currentMoney += moneyMore;
								System.out.println("this is current money " + currentMoney);
								System.out.println("you can buy it right now !");		
							}
					
						}
						opption = false;
						currentMoney -= priceCoca;
						
						break;
					case 3:
						
						if (currentMoney < priceCoca) {
							while (currentMoney <= price7up) {
								System.out.println("7up costs   : " + priceCoca);
								System.out.println("this is current : " + currentMoney);
								System.out.println("you do not have enough money to buy the product");
								System.out.println("Please, insert the money more");
								int moneyMore = sc.nextInt();
								currentMoney += moneyMore;
								System.out.println("this is current money " + currentMoney);
								System.out.println("you can buy it right now !");		
							}
					
						}
						opption = false;
						currentMoney -= priceCoca;
						
						break;
						
					default:
						break;
					}
				}

				System.out.println("Your remaining money is : " + currentMoney);
				System.out.println("Confirm option key : 1 or 2 ");
				System.out.println("1.You want get drink and return money right now");
				System.out.println("2.if you want to other product?");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Your remaining money is : " + currentMoney);
					System.out.println("Thank you and see you late ! ^-^");
					flag = false;
					break;
				case 2:
					System.out.println(currentMoney);
					System.out.println("wating ... back to menu .");
					opption = true;
					break;
				default:
					break;
				}

			} else {
				System.out.println("Please choose the product");
				currentMoney += inputMoney;
				System.out.println(currentMoney);
				while(opption){
					System.out.println("menu" + currentMoney);
					System.out.println("Please choose the case 1 2 3 :");
					System.out.println("1.Pesi : 600 ");
					System.out.println("2.Coca : 500 ");
					System.out.println("3.7up : 400 ");
					int item = sc.nextInt();
					switch (item) {
					case 1:
						
						if (currentMoney < pricePesi) {
							while (currentMoney <= pricePesi) {
								System.out.println("Pepsi costs   : " + pricePesi);
								System.out.println("this is current : " + currentMoney);
								System.out.println("you do not have enough money to buy the product");
								System.out.println("Please, insert the money more");
								int moneyMore = sc.nextInt();
								currentMoney += moneyMore;
								System.out.println("this is current money " + currentMoney);
								System.out.println("you can buy it right now !");		
							}
					
						}
						opption = false;
						currentMoney -= pricePesi;
						
						break;
					case 2:
						
						if (currentMoney < priceCoca) {
							while (currentMoney <= priceCoca) {
								System.out.println("Coca costs   : " + priceCoca);
								System.out.println("this is current : " + currentMoney);
								System.out.println("you do not have enough money to buy the product");
								System.out.println("Please, insert the money more");
								int moneyMore = sc.nextInt();
								currentMoney += moneyMore;
								System.out.println("this is current money " + currentMoney);
								System.out.println("you can buy it right now !");		
							}
					
						}
						opption = false;
						currentMoney -= priceCoca;
						
						break;
					case 3:
						
						if (currentMoney < priceCoca) {
							while (currentMoney <= price7up) {
								System.out.println("7up costs   : " + priceCoca);
								System.out.println("this is current : " + currentMoney);
								System.out.println("you do not have enough money to buy the product");
								System.out.println("Please, insert the money more");
								int moneyMore = sc.nextInt();
								currentMoney += moneyMore;
								System.out.println("this is current money " + currentMoney);
								System.out.println("you can buy it right now !");		
							}
					
						}
						opption = false;
						currentMoney -= priceCoca;
						
						break;
						
					default:
						break;
					}
				}

				System.out.println("Your remaining money is : " + currentMoney);
				System.out.println("Confirm option key : 1 or 2 ");
				System.out.println("1.You want get drink and return money right now");
				System.out.println("2.if you want to other product?");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Your remaining money is : " + currentMoney);
					System.out.println("Thank you and see you late ! ^-^");
					flag = false;
					break;
				case 2:
					System.out.println(currentMoney);
					System.out.println("wating ... back to menu .");
					opption = true;
					break;
				default:
					break;
				}
				
			}

		}

	}

}
