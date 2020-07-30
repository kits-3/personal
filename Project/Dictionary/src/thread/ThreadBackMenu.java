package thread;

public class ThreadBackMenu implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Please wait for 2s to come back menu options");
			Thread.sleep(1000);
			System.out.println("2...");
			Thread.sleep(1000);
			System.out.println("1...");
			Thread.sleep(1000);
			System.out.println("0...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
