package vendingmachine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
	static String productName;
	static int productPrice;
	
	public boolean exportInvoice(List<Product> data) {
		String fileInvoice = "invoice.txt";
		try {
			FileOutputStream fo = new FileOutputStream(fileInvoice);
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fo);
			String bill = "------------ BILL ------------\n";
			bill += "Product\t\t\tPrice\n";
			int total = 0; 
			
			for (Product item: data){
				bill += item.name + "\t\t\t" + item.price + "\n";
				total += item.price;
				
	        }
			
			bill += "Total\t\t\t" + total;
			
			byte[] bytes = bill.getBytes();
			fo.write(bytes); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
