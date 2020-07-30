package thread;

public class ThreadWatingAnswer implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(11000);
			System.out.println("You have 7s to complete mission !");
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
			System.out.print("0...");
			System.out.println("time out!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
