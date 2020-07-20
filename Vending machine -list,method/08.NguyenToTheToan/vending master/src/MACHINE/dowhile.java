package MACHINE;

import java.util.Scanner;

public class dowhile {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Ban nhap 1 so:");
	int n=sc.nextInt();
	int gt=1;
	int i=1;
	do {
		gt=gt*i;
		i++;
	}
	while(i<=n);
	System.out.println(n+"!="+gt);
	
}
}
