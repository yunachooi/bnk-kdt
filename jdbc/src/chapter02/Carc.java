package chapter02;

public interface Carc {
	public int sum(int a, int b);
	public int minus(int a, int b);
	public int mul(int a, int b);
	public int div(int a, int b);
	public default int power(int a) {
		return a * a;
	} //인터페이스에 추상메서드를 하나 추가 시 전체에 추가해야하는 상황 발생 시 구현 방법
}
