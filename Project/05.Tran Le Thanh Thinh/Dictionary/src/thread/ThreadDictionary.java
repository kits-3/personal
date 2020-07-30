package thread;

public class ThreadDictionary implements Runnable {
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
//			Thread.sleep(11000);
			System.out.println("You have 10s to memorize this words");
			System.out.print("10...");
			Thread.sleep(1000);
			System.out.print("9...");
			Thread.sleep(1000);
			System.out.print("8...");
			Thread.sleep(1000);
			System.out.print("7...");
			Thread.sleep(1000);
			System.out.print("6...");
			Thread.sleep(1000);
			System.out.print("5...");
			Thread.sleep(1000);
			System.out.print("4...");
			Thread.sleep(1000);
			System.out.print("3...");
			Thread.sleep(1000);
			System.out.print("2...");
			Thread.sleep(1000);
			System.out.print("1...");
			Thread.sleep(1000);
			System.out.println("0...");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
