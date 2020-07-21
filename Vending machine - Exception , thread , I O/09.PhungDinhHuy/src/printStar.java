
public class printStar {

	public static void printStar1(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = n; j > i; j--) {

				System.out.print(" ");
			}

			for (int k = 0; k < 2 * i - 1; k++) {
				System.out.print("*");
			}

			for (int m = n; m > i; m--) {
				System.out.print(" ");
			}

			System.out.println();
		}

	}

	public static void printStar2(int n) {
		int i = 1;
		while (i <= n) {

			for (int j = 1; j <=n- i; j++) {

				System.out.print(" ");
			}

			for (int k = 0; k < 2 * i - 1; k++) {
				System.out.print("*");
			}

			for (int m = n; m > i; m--) {
				System.out.print(" ");
			}

			System.out.println();
			i++;
		}

	}
	
	
	public static void printStar3(int n) {
//		*
//		* *
//		* * *
//		* * * *
//		* * * * *	
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
	}
	
	
	
	public static void printStar4(int n) {
//        * 
//      * * 
//    * * * 
//  * * * * 
//* * * * * 

		for(int i=0;i<n;i++) {
			
			for(int j=n;j>i;j--) {
				System.out.print(" ");
			}
			
			for(int k=0;k<=i;k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
	}
	

	public static void main(String[] args) {
		printStar1(5);
		System.out.println();
		printStar2(5);
//		printStar3(5);
//		printStar4(5);
	}

}
