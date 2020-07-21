import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeBill {
	private String stringConvert;
	
	public void setStringConvert(String str) {
		this.stringConvert=str;
	}
	public String getStringConvert() {
		return this.stringConvert;
	}
	
	public void convert() {
		String url="C:/Users/PC06/Desktop/JAVA EE/06.HoVanHoaiTri/Bill/bill.txt";
		String getString = getStringConvert();
		try {
			FileOutputStream out = new FileOutputStream(url);
			byte[] bytes = getString.getBytes();
			try {
				out.write(bytes);
				out.flush();
				out.close();
				System.out.println("Bill done!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
