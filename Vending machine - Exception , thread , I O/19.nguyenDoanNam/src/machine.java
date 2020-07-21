import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class machine implements intClass {
	Scanner scanner = new Scanner(System.in);
	int old_money = 0;
	int money = 0;
	int product;
	String name;
	ArrayList<String> bills = new ArrayList<String>();

	@Override
	public void main(int a, int b, int c, String x, String y, String z) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Input money:");
		money = scanner.nextInt();
		money = money + old_money;
		System.out.println("You have " + money + " money");
		if (money < a && money < b && money < c) {
			old_money = money;
			System.out.println("You dont have enough money.");
			System.out.println("You can get money or add money");
			return_money(a, b, c, x, y, z, name, product );
		} else {
			System.out.println("-----Product----------------------------------");
			System.out.println("---------------1." + x + "------" + a + "---------------");
			System.out.println("---------------1." + y + "------" + b + "---------------");
			System.out.println("---------------1." + z + "------" + c + "---------------");
			System.out.print("Choose product:");
			product = scanner.nextInt();
			switch (product) {
			case 1:
				name = x;
				product = a;
				break;
			case 2:
				name = y;
				product = b;
				break;
			case 3:
				name = z;
				product = c;
				break;
			default:
				System.out.println("Please choose product on list");
				break;
			}
			if (money < product) {
				System.out.println("you do not have enough money");
				old_money = money;
				return_money(a, b, c, x, y, z, name, product);

			} else {
				money = money - product;
				old_money = money;
				System.out.println("You buy product success. You have " + money + " money");
				System.out.println("You will buy new product?");
				return_money(a, b, c, x, y, z, name, product);
			}
		}
	}

	public void return_money(int a, int b, int c, String x, String y, String z, String name,int product) {
		System.out.println("Get money: y/n ?");
		String return_money = scanner.next();
		switch (return_money) {
		case "y":
			System.out.print("Money return to you. You have " + money + " money \n");
			bills.add(name);
			for(int i = 0; i< bills.size();i++)
			{
				System.out.println(" You buy " + bills.get(i) + " with " + product + " VND \n"); 
			}
			Fileout(name, product);
			break;
		default:
		    bills.add(name);
			main(a, b, c, x, y, z);
			break;
		}
	}

	public void Fileout(String name, int bill) {
		try {
			FileOutputStream fout = new FileOutputStream("D:\\eclip\\Machine_ab\\src\\bill.txt");
			for(int i = 0; i< bills.size();i++)
			{
				String s = " You buy " + bills.get(i) + " with " + bill + " VND \n";
				byte b[] = s.getBytes();
				fout.write(b);
			}
			fout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}