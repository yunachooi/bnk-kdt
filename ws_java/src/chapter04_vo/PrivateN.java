package chapter04_vo;

public class PrivateN {

	private int n;
	private String s;

	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getS() {
		return s;
	}
	public String showInfo() {
		return "a.showInfo() >> n = " + n + ", s = " + s;
	}
	
	// 인스턴스의 멤버변수 값들을 제공하는 것을 하는 것으로 약속
	// 어노테이션 - 표시 및 기능 수행, 함수 재정의, 함수 이름을 틀리는 것을 막기 위함.
	// 오버라이드 : 함수의 시그니처는 동일하지만 기능은 달라야함.
	// 오버로딩 : 함수의 이름은 동일하지만 시그니처가 달라야함.
	@Override
	public String toString() {
		return "a >> n = " + n + ", s = " + s;
	}
}