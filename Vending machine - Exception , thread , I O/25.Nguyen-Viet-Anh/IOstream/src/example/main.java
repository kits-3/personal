package example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class main {
	public static void main(String[] args) {
		try {
			String fileDir = "C:/Users/PC25/Desktop/exam2/text.txt";
			String pasteDir = "C:/Users/PC25/Desktop/exam2/text2.txt";
			
			FileInputStream fi = new FileInputStream(fileDir);
			FileOutputStream fo = new FileOutputStream(pasteDir);
			
			int readByteNum;
			byte[] bytes = new byte[300];
			StringBuffer buffer = new StringBuffer();
			while((readByteNum = fi.read(bytes)) != -1) {
				fo.write(bytes, 0, readByteNum);
				buffer.append(new String(bytes, 0, readByteNum));
			}
			String str = buffer.toString();
			System.out.println("result: " + str);
			fo.flush();
			fo.close();
			fi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
