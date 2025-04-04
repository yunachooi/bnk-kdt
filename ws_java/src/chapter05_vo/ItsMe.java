package chapter05_vo;

public class ItsMe implements Fly, Run, Speak {
	public void fly() {
		System.out.println("나는 날 수 있습니다...");
	}
	public void run() {
		System.out.println("나는 뛸 수 있습니다...");
	}
	public void speak() {
		System.out.println("나는 말할 수 있습니다...");
	}
}
