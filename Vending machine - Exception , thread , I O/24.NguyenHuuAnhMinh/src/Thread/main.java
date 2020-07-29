package Thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class main {

	public static void main(String[] args) {
		try{
			String FileDir = "D:/io/text.txt";
			String pasteDir = "D:/io/text2.txt";
			
			FileInputStream f1 = new FileInputStream(FileDir);
			FileOutputStream f0 = new FileOutputStream(pasteDir);
			
			int readbyNum;
			byte[] bytes = new byte[300];
			StringBuffer buffer = new StringBuffer();
			
			while((readbyNum = f1.read(bytes))!= -1){
				f0.write(bytes,0,readbyNum);
				buffer.append(new String(bytes , 0 ,readbyNum));
			}
			String str = buffer.toString();
			System.out.println("result: " + str);
			f0.flush();
			f0.close();
			f1.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
