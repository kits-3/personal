package Example;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine implements Vending {
	ArrayList<Drink> List = new ArrayList<Drink>();
	@Override
	public ArrayList<Drink> getList() {
		// TODO Auto-generated method stub
		List.add(new Drink(0,"coca",1000));
		List.add(new Drink(1, "pepsi",2000));
		List.add(new Drink(2, "soda",3000));
		return List;
		
	}
	ArrayList<Food> List1 = new ArrayList<Food>();
	@Override
	public ArrayList<Food> getList1() {
		// TODO Auto-generated method stub
		List1.add(new Food(0, "banhmi", 1000));
		List1.add(new Food(1, "noodle", 2000));
		List1.add(new Food(0, "pho", 3000));
		return List1;
	}

	@Override
	public void displayList() {
		// TODO Auto-generated method stub
		for (int i = 0; i < List.size(); i++) {
			System.out.println("ID:"+List.get(i).getId()+"Name:"+List.get(i).getName()+" Price:"+List.get(i).getPrice());
		}
	}

	@Override
	public int selectProduct(int money, int num) {
		for(int i=0; i<List.size(); i++) {
			if (num == List.get(i).getId()) {
				if (money > List.get(i).getPrice()) {
					money -= List.get(i).getPrice();
					System.out.println("your choose is: "+List.get(i).getName());
				}
			}
		}
		return money;
		
	}

	@Override
	public void returnMoney() {
		
		
	}


	@Override
	public void outPut() {
		// TODO Auto-generated method stub
		try {
			String fileDir = "D:/java/21072020/test.txt";
			String pasteDir = "D:/java/21072020/test2.txt";
			FileInputStream fi = new FileInputStream(fileDir);
			FileOutputStream fo = new FileOutputStream(pasteDir);
			FileWriter myWriter = new FileWriter("D:/java/20072020/test.txt");
			for(int i=0; i<List.size(); i++) {
			myWriter.write("\r\nName:"+List.get(i).getName()+" Price:"+List.get(i).getPrice()+"\r\n");
			}
			for(int i=0; i<List1.size(); i++) {
			myWriter.write("\r\nName:"+List1.get(i).getName()+" Price:"+List1.get(i).getPrice()+"\r\n");
			}
		    myWriter.close();
			int readByteNum;
			byte[] bytes = new byte[300];
			StringBuffer buffer = new StringBuffer();
			while ((readByteNum = fi.read(bytes)) != -1) {
				fo.write(bytes,0,readByteNum);
				buffer.append(new String(bytes,0,readByteNum));
			}
			String str = buffer.toString();
			System.out.println("File name:\r\n "+str);
			fo.flush();
			fo.close();
			fi.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public int getLowestMoney(int money) {
		int min= List.get(0).getPrice();
		for(int i=0; i<List.size(); i++) {
			if(min>List.get(i).getPrice()) {
				min= List.get(i).getPrice();
			}
		}
		return min;
	}

	@Override
	public void displayList1() {
		// TODO Auto-generated method stub
		for (int i = 0; i < List1.size(); i++) {
			System.out.println("ID:"+List1.get(i).getId()+"Name:"+List1.get(i).getName()+" Price:"+List1.get(i).getPrice());
		}
	}

	@Override
	public int selectProduct1(int money, int num) {
		// TODO Auto-generated method stub
		for(int i=0; i<List1.size(); i++) {
			if (num == List1.get(i).getId()) {
				if (money > List1.get(i).getPrice()) {
					money -= List1.get(i).getPrice();
					System.out.println("your choose is: "+List1.get(i).getName());
				}
			}
		}
		return money;
	}

	
	
}
