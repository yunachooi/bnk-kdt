package chapter04;

public class MyThreadTest {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		t1.setName("Thread-A");
		t2.setName("Thread-B");
		//run 메소드를 직접 호출할 경우 미실행 따라서, start 메소드가 run 메소드를 실행하도록 해야함
		t1.start();
		t2.start();
		System.out.println("------End Of Main------");
	}

}
