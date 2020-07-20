package machine;
import java.util.Scanner;



public class mainn  implements foodDrinkFruit  {
	
public static void main(String[] args) {
	System.out.println("you choose 1.drink   2.food   3.fruit");
	Scanner sc = new Scanner(System.in);
	Integer c=sc.nextInt();
	machine m = new machine();
	if (c==1) {
		drink f=new drink();
		f.name();
		
		start start1= new start();
	}
	else if (c==2) {
		food f1 =new food();
		f1.name();
		start start1= new start();
	
	}
	else {
		fruit f=new fruit();
		f.name();
			
		start start1= new start();
		
	}
	
	
}
}
