import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Input_ouput {
	
	public static void main(String[] args) {
		try {
			String fileDir = "C:/Users/PC09/Desktop/exam/text.txt";
			String pasteDir = "C:/Users/PC09/Desktop/exam/text2.txt";
			
			FileInputStream fi = new FileInputStream(fileDir);
			FileOutputStream fo = new FileOutputStream(pasteDir);
			
			int readByNum;
			byte[] bytes = new byte[300];
			StringBuffer buffer = new StringBuffer();
			while((readByNum = fi.read(bytes)) != -1) {
				fo.write(bytes, 0, readByNum);
				buffer.append(new String(bytes,0,readByNum));
			}
			String str = buffer.toString();
			System.out.println("result : " + str);
			fo.flush();
			fo.close();
			fi.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
