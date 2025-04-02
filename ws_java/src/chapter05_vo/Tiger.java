package chapter05_vo;

public class Tiger extends Animal {
	public Tiger() {
		
	}
	@Override //재정의한 메소드의 오류를 방지하기 위함.
	public void cry() {
		System.out.println("어흥~");
	}
}
