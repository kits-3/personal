package com.impl;

import java.util.ArrayList;
import java.util.List;

import com.entity.Drink;
import com.interfacePkg.DrinkVending;

public class DrinkVendingImpl implements DrinkVending{
	List<Drink> list = new ArrayList<Drink>();

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
				if(money >= list.get(i).getPrice()) {
					money -= list.get(i).getPrice();
					System.out.println("You got "+list.get(i).getName());
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



	
	


}
