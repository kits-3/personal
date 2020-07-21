package vendingmachine;

public class MakeTime extends Thread{

	public synchronized void run() {
		int i = 3;
		System.out.println("Please wait...");
		while(i >= 1) {
			try {
				System.out.println(i + "s...");
				Thread.sleep(1000);
				i--;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Output product success!");
	}
	
}
