package VendingMaChineOOP2;

public class Thread_Example implements Runnable{

	String s;
	Thread_Example(String s){
		this.s=s;
	}
	
	public void run() {
		try {
			
				Thread.sleep(3000);
				Thread thread = Thread.currentThread();
				System.out.println(s);
			
		} catch (InterruptedException e) {
		}
	}
	
}
