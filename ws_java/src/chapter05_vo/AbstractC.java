package chapter05_vo;

public class AbstractC implements IB{

	@Override
	public void f1() {
		System.out.println("AbstractC클래스의 f1 함수 실행...");
	}

	@Override
	public int f2() {
		System.out.println("AbstractC클래스의 f1 함수 실행...");
		return 0;
	}
	
}
