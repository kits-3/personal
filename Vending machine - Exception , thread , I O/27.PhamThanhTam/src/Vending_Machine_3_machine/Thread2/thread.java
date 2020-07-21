package Vending_Machine_3_machine.Thread2;

public class thread implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("your lucky when you buy less 3 product have same name");
			System.out.println("'_'");
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
