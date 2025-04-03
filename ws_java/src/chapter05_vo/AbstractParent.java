package chapter05_vo;

public abstract class AbstractParent {
	private int n;
	
	public AbstractParent(int n){
		System.out.println("부모 AbstractParent 클래스 생성자 호출...");
		this.n = n;
	}
	public void f() {
		System.out.println("f() 함수 실행...");
	}
	
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public abstract void af();
}
