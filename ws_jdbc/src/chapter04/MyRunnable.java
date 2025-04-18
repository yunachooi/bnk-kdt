package chapter04;

public class MyRunnable implements Runnable {
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
