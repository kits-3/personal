package Thread_Example;

public class Thread_Example implements Runnable{

	public void run() {
		try {
			for(int i = 0 ; i < 10 ; i++) {
				Thread.sleep(300);
				System.out.println("run thread !!");
				Thread thread = Thread.currentThread();
				System.out.println("main name : "+ thread.getName());
				method();
			}
		} catch (InterruptedException e) {
		}
	}
	public synchronized void method() {
		Thread thread = Thread.currentThread();
		try {
			for(int i = 0 ; i < 10 ; i++) {
				Thread.sleep(1000);
				System.out.println("do : "+ thread.getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
