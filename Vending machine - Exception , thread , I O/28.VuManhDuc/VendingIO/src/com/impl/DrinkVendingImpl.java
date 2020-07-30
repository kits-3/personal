package com.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.entity.Drink;
import com.entity.Product;
import com.interfacePkg.DrinkVending;

public class DrinkVendingImpl implements DrinkVending,  Runnable{
	List<Drink> list = new ArrayList<Drink>();
	ArrayList<Drink> listProducts = new ArrayList<Drink>();

	@Override
	public List<Drink> getListDrink() {
		list.add(new Drink(0, "coca", 5000));
		list.add(new Drink(1, "pepsi", 10000));
		list.add(new Drink(2, "beer", 20000));
		list.add(new Drink(3, "7up", 10000));
		return list;
	}

	@Override
	public void displayDrinks() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i +". "+list.get(i).getName()+ ", price: "+list.get(i).getPrice());
		}
	}

	

	@Override
	public void returnMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int selectProduct(int money, int number) {
		// TODO Auto-generated method stub

		
		for (int i = 0; i < list.size(); i++) {
			if(number == list.get(i).getId()) {
				listProducts.add(list.get(i));
				if(money >= list.get(i).getPrice()) {
					money -= list.get(i).getPrice();
					System.out.println("You got "+list.get(i).getName());
				}
				else {
					System.out.println("You dont have enought money to pay this item. ");
				}
			}
		}
		return money;
	}

	@Override
	public int getLowestMoney(int money) {
		int min = list.get(0).getPrice();
        for (int i = 0;i < list.size();i++){
            if (min > list.get(i).getPrice()){
                min = list.get(i).getPrice();
            }
        }
        return min;
	}

	@Override
	public void printReceipt() {

		try {
			String pasteDir = "C:/Users/PC28/Desktop/New folder/text2.txt";

			FileWriter fw = new FileWriter(pasteDir);
			BufferedWriter bu = new BufferedWriter(fw);
			
			
			for (int i = 0; i < listProducts.size(); i++) {
				bu.write(i+". "+listProducts.get(i).getName()+", "+listProducts.get(i).getPrice());
				bu.write("\r\n");
			}
			
			bu.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
				Thread.sleep(300);
				System.out.println("Please wait");
				method();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public synchronized void method() {
		Thread thread = Thread.currentThread();
		try {
			Thread.sleep(1000);
			System.out.println("main thread: "+thread.getName());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}



	
	


}
