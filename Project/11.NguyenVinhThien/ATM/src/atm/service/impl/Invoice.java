package atm.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Invoice {
	
	Scanner scan = new Scanner(System.in);
	
	public boolean getMenu(){
		boolean status = false;
		boolean check = true;
		
		while(check) {
			System.out.println("Print invoice? (y or n)");
			String n = scan.nextLine();
			if(n.equalsIgnoreCase("y")) {
				check = false;
				status =  true;
			} else if(n.equalsIgnoreCase("n")) {
				check = false;
				status = false;
			}
		}
		return status;
	}
	
	public boolean print(String bill) {
		String fileInvoice = "invoice.txt";
		try {
			FileOutputStream fo = new FileOutputStream(fileInvoice);
			
			byte[] bytes = bill.getBytes();
			fo.write(bytes);
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
