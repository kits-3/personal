package com.interfacePkg;
import java.util.List;

import com.entity.Drink;

public interface DrinkVending {
	public int getLowestMoney(int money);
	public List<Drink> getListDrink();
	public void displayDrinks();
	public int selectProduct(int money, int number);
	public void returnMoney();
}
