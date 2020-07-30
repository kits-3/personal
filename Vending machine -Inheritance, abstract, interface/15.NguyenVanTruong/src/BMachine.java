import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BMachine implements IMachine {

	static int money;
	@Override
	public void inputMoney() {
		do {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input money");
		money += scan.nextInt();
		}while(money<200 );
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectProduct() {
		Scanner scan = new Scanner(System.in);
		String selectProduct;
		boolean checkMore = true;
		List <String> listProduct = new ArrayList<>();
		listProduct.add("Ramem(1000)");
		listProduct.add("KimBap(500)");
		listProduct.add("KimChi(200)");
		for (int i = 0; i < listProduct.size(); i++) {
			System.out.println(listProduct.get(i));
		}
		System.out.println("Please select product");
		do {
		selectProduct = scan.next();
		if(selectProduct.equals("KimChi")) {
				System.out.println("Your select: KimChi");
				money = money - 200;
				System.out.println("Your money now:" +money);
				}		
		else if(selectProduct.equals("KimBap")) {
			if(500>money) {
				checkMore = false;
				inputMoney();
				selectProduct();
				break;
			}
			System.out.println("Your select: KimBap");
			money = money - 500;
			System.out.println("Your money now:" +money);
			
		}
		else if(selectProduct.equals("Ramem")) {
			if(1000>money) {
				checkMore = false;
				inputMoney();
				selectProduct();
				break;
			}
			System.out.println("Your select: Ramem");
			money = money - 1000;
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
		
	}
		// TODO Auto-generated method stub
		
	

}
