package machinevending;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportReceipt {
	List<Product> listProduct;
	private StringBuffer buffer;
	
	public ExportReceipt(List<Product> listProduct) {
		this.listProduct = listProduct;
		buffer = new StringBuffer();
	}
	
	public void createReceipt() {		
		try {
			String receipt = "../Vending-machine/receipt/Receipt.txt";
			FileOutputStream fo = new FileOutputStream(receipt);
			int totalMoney = 0;
			buffer.append("=========================Receipt=========================");
			for(int i = 0; i < listProduct.size(); i++) {
				buffer.append("\n");
				buffer.append((i+1) + ". " + listProduct.get(i).getName() + "      " + listProduct.get(i).getCost());
				totalMoney += listProduct.get(i).getCost();
			}
			buffer.append("\nTotal money : " + totalMoney);
			
			byte[] bytes = buffer.toString().getBytes();

			fo.write(bytes);
			fo.flush();
			fo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportConsole() {
		System.out.println(buffer.toString());
	}
}
