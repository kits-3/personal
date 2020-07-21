package Thread_Example;

public class testThread {

	public static void main(String[] args) {
		Thread_Example thExample=new Thread_Example();
		Thread thread=new Thread(thExample);
		
		thread.start();
		
	}
}
