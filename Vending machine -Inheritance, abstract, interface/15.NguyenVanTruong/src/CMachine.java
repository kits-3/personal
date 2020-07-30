import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CMachine implements IMachine{

	static int money;
	@Override
	public void inputMoney() {
		do {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input money");
		money += scan.nextInt();
		}while(money<100 );
		// TODO Auto-generated method stub
		//selectProduct();
	}

	@Override
	public void selectProduct() {
		Scanner scan = new Scanner(System.in);
		String selectProduct;
		boolean checkMore = true;
		List <String> listProduct = new ArrayList<>();
		listProduct.add("Pencil(100)");
		listProduct.add("Book(500)");
		listProduct.add("Rules(200)");
		for (int i = 0; i < listProduct.size(); i++) {
			System.out.println(listProduct.get(i));
		}
		System.out.println("Please select product");
		do {
		selectProduct = scan.next();
		if(selectProduct.equals("Pencil")) {
				System.out.println("Your select: Pencil");
				money = money - 100;
				System.out.println("Your money now:" +money);
				}		
		else if(selectProduct.equals("Rules")) {
			if(200>money) {
				checkMore = false;
				inputMoney();
				selectProduct();
				break;
			}
			System.out.println("Your select: Rules");
			money = money - 200;
			System.out.println("Your money now:" +money);
			
		}
		else if(selectProduct.equals("Book")) {
			if(500>money) {
				checkMore = false;
				inputMoney();
				selectProduct();
				break;
			}
			System.out.println("Your select: Book");
			money = money - 500;
			System.out.println("Your money now:" +money);
		}

		
		
		System.out.println("Do you want to buy more?Select Y/N");
		String answer = scan.next();
		if(answer.equals("Y")) {
			checkMore = false;
			inputMoney();
			selectProduct();
			break;
		}
		else if(answer.equals("N")) {
			System.out.println("Goodbye");
			checkMore=false;
		}
		}while(checkMore);
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
	}

}
