package OOP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
	public static void main(String[] args) throws IOException {
		/* create file */
		FileWriter writer = new FileWriter("D:\\test-createfile.txt");
		/* create intance BufferedWriter */
		BufferedWriter buffer = new BufferedWriter(writer);
		/* It is used to write a single character. */
		buffer.write("Welcome to java.");
		/* It is used to add a new line with a carriage return. */
		buffer.newLine();
		/* It is used to discharge BufferedWriter. */
		buffer.flush();
		/* It is used to close BufferedWriter */
		buffer.close();
		System.out.println("Success...");
		
		/* create intance FileReader and import file it must read  */
		FileReader fr = new FileReader("D:\\test-createfile.txt");
		/* create intance BufferedWriter */
		BufferedReader br = new BufferedReader(fr);
		/*br.read() : It is used to read single character characters.*/
		int i;
		while ((i = br.read()) != -1) {
			System.out.print((char) i);
		}
		br.close();
		fr.close();

	}
	
	
}