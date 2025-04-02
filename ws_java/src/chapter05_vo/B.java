package chapter05_vo;

public class B extends A {
	public int k;
	
	public void fB() {
		System.out.println("fB함수 실행...");
	}
	
	public B(){
		super(10);
		System.out.println("B 생성자 실행...");
	}
	public void fA() {
		System.out.println("클래스 B의 fA 함수 실행...");
	}
}
