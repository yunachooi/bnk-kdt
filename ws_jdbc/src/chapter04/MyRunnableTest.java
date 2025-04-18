package chapter04;

public class MyRunnableTest {

	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();
		
		Thread t1 = new Thread(runnable, "Thread-A");
		Thread t2 = new Thread(runnable, "Thread-B");
		
		t1.start();
		t2.start();
	}

}
