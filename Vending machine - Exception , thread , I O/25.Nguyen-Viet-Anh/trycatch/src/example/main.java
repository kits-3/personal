package example;

public class main {
	public static void main(String[] args) {
		ThreadRun tr = new ThreadRun();
		Thread thread = new Thread(tr);
		
		thread.start();
		
		try {
			for (int i = 0; i < 10; i++) {
				thread.sleep(500);
				System.out.println("Thread run ~~");
			}
		}catch (Exception e) {}
	}
}
