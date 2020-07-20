package example1;

public class test {

	public static void main(String[] args) {
		final int HEIGHT =4;
		String result = "";
		String record = "";
		String space = "";
		String character = "";
		
		int line =1;
		while(line <= HEIGHT) {
			space = "";
			character = "";
			for(int s = 1; s <= HEIGHT - line; s++) space += " ";
			for(int c = 1; c <= 2*line -1; c++) character += "*";
			
			record = space + character +"\n";
			result += record;
			line++;
		}
		System.out.println(result);

	}

}
