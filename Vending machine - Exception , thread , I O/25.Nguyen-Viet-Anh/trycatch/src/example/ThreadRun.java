package example;

public class ThreadRun implements Runnable{
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(300);
				System.out.println("run thread ~ " );
			}
		}catch(Exception e) {
			
		}
		
	}
}
