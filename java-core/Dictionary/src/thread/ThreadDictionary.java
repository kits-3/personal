package thread;

public class ThreadDictionary implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("You have 10s to memorize this words");
			System.out.println("10...");
			Thread.sleep(1000);
			System.out.println("9...");
			Thread.sleep(1000);
			System.out.println("8...");
			Thread.sleep(1000);
			System.out.println("7...");
			Thread.sleep(1000);
			System.out.println("6...");
			Thread.sleep(1000);
			System.out.println("5...");
			Thread.sleep(1000);
			System.out.println("4...");
			Thread.sleep(1000);
			System.out.println("3...");
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
