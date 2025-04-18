package chapter04;

public class MyThread extends Thread {
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			//현재 실행 중인 스레드의 이름을 알려줌
			System.out.println(Thread.currentThread().getName() + " : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
