package ex1;

import java.io.FileOutputStream;

public interface ChooseProduct {
	public class vending_machine1 extends vendingmachine {
		
		public static void name_price(){
			list2.add(20);
			list2.add(30);
			list2.add(40);
			list2.add(10);
			
			list3.add("coca");
			list3.add("pepsi");
			list3.add("milk");
			list3.add("water");
		}
		
}
	public class vending_machine3 extends vendingmachine {
		
		public static void name_price(){
			list2.add(20);
			list2.add(30);
			list2.add(40);
			list2.add(10);
			
			list3.add("gift1");
			list3.add("gift2");
			list3.add("gift3");
			list3.add("gift4");
		}
		
}
	public class vending_machine2 extends vendingmachine {
		
		public static void name_price(){
			list2.add(20);
			list2.add(30);
			list2.add(40);
			list2.add(10);
			
			list3.add("rice");
			list3.add("chicken");
			list3.add("bibimbap");
			list3.add("sushi");
		}
		
}
	public class stop extends vendingmachine  {
		stop(){
			String pasteDir = "C:/Users/phaml/Desktop/1.txt";
			int sum = 0;
			for (int i = 0; i < addmoney.size(); i++) {
				sum += addmoney.get(i);
			}
			int total= excess_money + sum;
			try {
				FileOutputStream outputStream = new FileOutputStream(pasteDir);
				
				for (int i = 0; i < listp.size(); i++) {
					String a = "\n" +listp.get(i) +"\t\t\t" + addmoney.get(i) ;			
					byte[] b = a.getBytes();
					outputStream.write(b);
					
				}
				String a = " \nTotal money:\t\t" + total + "\nyour excess_money\t" + excess_money;
				byte[] b = a.getBytes();
				outputStream.write(b);
				
				outputStream.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
	}
}