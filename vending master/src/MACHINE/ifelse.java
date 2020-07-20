package MACHINE;

import java.util.Scanner;

public class ifelse {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Mời bạn nhập 1 tháng:");
		int t=sc.nextInt();
		if(t==1 ||t==3||t==5||t==7||t==8||t==10||t==12) {
			System.out.println("Thang"+" "+t+" "+"Có 31 ngày");
		}
		else if(t==4 || t==6 || t==11) {
			System.out.println("Thang "+" "+t+" "+"Có 30 ngày");
		}
		else if(t==2)
		{
			System.out.println("Thang "+" "+t+" "+"Có 29 ngày");
		}else
		{
			System.out.println("Bạn nhập tháng "+" "+t+" "+"sai rùi");
		}
	}
}
