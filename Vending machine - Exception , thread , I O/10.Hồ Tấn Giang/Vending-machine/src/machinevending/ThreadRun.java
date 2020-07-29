package machinevending;

public class ThreadRun implements Runnable {
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			
			System.out.println("You can get your order");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
