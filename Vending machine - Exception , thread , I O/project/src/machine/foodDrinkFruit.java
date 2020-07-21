package machine;

import java.io.FileOutputStream;

public interface foodDrinkFruit {
	 public class food extends machine {
			public static void name() {
				product.add("chicken");
				product.add("piza");
				product.add("hamburger");
				product.add("rice");
					
				productPrice.add(600);
				productPrice.add(400);
				productPrice.add(900);
				productPrice.add(100);

			}


}
	 public class drink extends machine {
			public static void name() {
				product.add("co");
				product.add("milk");
				product.add("coki");
				product.add("juice");
					
				productPrice.add(600);
				productPrice.add(400);
				productPrice.add(900);
				productPrice.add(100);
		
			} 
	 }
	 
	 public class fruit extends machine {
			public static void name() {
				product.add("apple");
				product.add("banana");
				product.add("aaa");
				product.add("bbb");
					
				productPrice.add(600);
				productPrice.add(400);
				productPrice.add(900);
				productPrice.add(100);
				
				
			}
			
	 }
	 public class start extends machine{
		 start() {
		 	machine m = new machine() ;
			money=m.inputMoney(money);	
			int min=0;
			min=m.minMoney(min);
			m.checkMoney();
	 }}
	 public class stop extends machine{
		 stop(){
				int sum = 0;
				for (int i = 0; i < priceadd.size(); i++) {

					sum += priceadd.get(i);

				}
			  String pasteDir ="C:/Users/phaml/Desktop/test2.txt";
			  
			  try {
				  FileOutputStream fo = new FileOutputStream(pasteDir);
				  int s=money+sum;
				  String s1=" \n your money\t" +s +"\n =========================Receipt=========================";
					byte[] b1 = s1.getBytes();
					fo.write(b1);
					String c=" \n your product" ;
					byte[] b = c.getBytes();
					fo.write(b);
							  	
				  
					for (int i = 0; i < productadd.size(); i++) {
					
						
						String d=" \n " +productadd.get(i) +"\t\t\t" +priceadd.get(i);
						byte[] b2 = d.getBytes();
						fo.write(b2);
						
					}
					String str = "\n =========================Receipt=========================" +" \n your excess money\t: " +money +"\n Thanks and goodbye!! ";
					  byte[] b2 = str.getBytes();
					  fo.write(b2);
					  fo.close();
				
			}
			  
			  catch (Exception e) {
				// TODO: handle exception
			}
		 }
	 }
	 public static void main(String[] args) {
		
	}
	 
	 
	 

}
