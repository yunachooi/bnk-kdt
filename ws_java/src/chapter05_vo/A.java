package chapter05_vo;

public class A {
	public int n;
	
	public void fA() {
		System.out.println("fA함수 실행...");
	}
	
	public A(int n){
		System.out.println("A 생성자 실행...");
		this.n = n;
	}
}
