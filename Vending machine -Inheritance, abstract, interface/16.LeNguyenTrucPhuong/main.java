package machine;

import java.util.Scanner;
import machine.drink;
import machine.food;
 public interface main  {
	 public class food1 extends food {}
	public static void main(String[] args) {
		System.out.println("you choose 1.drink   2.food   3.fruit");
		Scanner sc = new Scanner(System.in);
		Integer c=sc.nextInt();
		if (c==1) {
			food1 f =new food1();
	
		}
	}

}
