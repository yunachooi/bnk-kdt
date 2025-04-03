package chapter05_vo;

public class AbstractB implements IB{
	// 클래스 AbstractB는 인터페이스 IB 구현체.
	// 인터페이스 IB의 추상메서드를 구현한 클래스.
	// 상속이라고도 하지만 정확한 용어는 아님.

	@Override
	public void f1() {
		System.out.println("AbstractB클래스의 f1 함수 실행...");
	}

	@Override
	public int f2() {
		System.out.println("AbstractB클래스의 f2 함수 실행...");
		return 0;
	}

}
