package MACHINE;

import java.util.Scanner;

public class scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số tiền bạn cần mua:");
		int a=sc.nextInt();
		System.out.println("Bạn vừa nhập :"+a);
		System.out.println("Mời bạn nhâp vào số double:");
		double b =sc.nextDouble();
		System.out.println("Bạn mới vừa nhap sớ double:"+b);
		System.out.println("Mời bạn nhập vào chuoi:");
		String Line=new Scanner(System.in).nextLine();
		System.out.println("Bạn moi vua nhâp: "+Line);
		
	}
}
