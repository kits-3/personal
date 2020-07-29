package MACHINE;

import java.util.Scanner;

public class while1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Mời bạn nhập vào số:");
		int n=sc.nextInt();
		int gt=1;
		int i=1;
		while(i<=n) {
			gt=gt*i;
			i++;
			
		}
		System.out.println(n+"!="+gt);
	}

}
