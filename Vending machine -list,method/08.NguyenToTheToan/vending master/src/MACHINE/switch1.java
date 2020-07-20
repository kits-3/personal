package MACHINE;

import java.util.Scanner;

public class switch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Mời bạn nhập vào 1 tháng:");
		int t=sc.nextInt();
//		switch(t)
//		{
//		case 1:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 3:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 5:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 7:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 8:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 10:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 12:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 4:
//			System.out.println("Tháng"+t+" có 30 ngày");
//			break;
//		case 6:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 9:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 11:
//			System.out.println("Tháng"+t+" có 31 ngày");
//			break;
//		case 2:
//			System.out.println("Tháng"+t+" có 29 hoặc 28 ngày");
//			break;
//		default:
//			System.err.println("Bạn đã nhập tháng"+t+" Sai");
//			break;
//		}
		switch(t) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng"+t+" có 31 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng"+t+" có 30 ngày");
			break;
		case 2:
			System.out.println("Tháng"+t+" có 28 ngày");
			break;	
		default:
			System.err.println("Tháng"+t+" sai");
			break;	
		}
	}

}
