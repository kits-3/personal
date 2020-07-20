package machine;
import java.util.Scanner;

import machine.drink;
import machine.food;

public class mainn {
public static void main(String[] args) {
	System.out.println("you choose 1.drink   2.food   3.fruit");
	Scanner sc = new Scanner(System.in);
	Integer c=sc.nextInt();
	if (c==1) {
		drink d=new drink();	
		d.product.add("coca");
		d.product.add("milk");
		d.product.add("coki");
		d.product.add("juice");
			
		d.productPrice.add(600);
		d.productPrice.add(400);
		d.productPrice.add(900);
		d.productPrice.add(100);
	 
		int money=0;
		money=d.inputMoney(money);	
		int min=0;
		min=d.minMoney(min);
		d.checkMoney();
	
	}
	else if (c==2) {
		food f=new food();
		 //List<String> product = new ArrayList();
		 //List<Integer> productPrice = new ArrayList();
			f.product.add("chicken");
			f.product.add("piza");
			f.product.add("hamburger");
			f.product.add("rice");
				
			f.productPrice.add(600);
			f.productPrice.add(400);
			f.productPrice.add(900);
			f.productPrice.add(100);
		 
			int money=0;
			money=f.inputMoney(money);	
			int min=0;
			min=f.minMoney(min);
			f.checkMoney();
		
	}
	else {
		fruit f=new fruit();
		 //List<String> product = new ArrayList();
		 //List<Integer> productPrice = new ArrayList();
		f.product.add("apple");
		f.product.add("banana");
		f.product.add("aaa");
		f.product.add("bbb");
			
		f.productPrice.add(600);
		f.productPrice.add(400);
		f.productPrice.add(900);
		f.productPrice.add(100);
	 
		int money=0;
		money=f.inputMoney(money);	
		int min=0;
		min=f.minMoney(min);
		f.checkMoney();
	}
	
}
}
