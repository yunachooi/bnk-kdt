package chapter02;

public class Carc1 implements Carc {
	@Override
	public int sum(int a, int b) {
		return a + b;
	}
	@Override
	public int minus(int a, int b) {
		return a - b;
	}
	@Override
	public int mul(int a, int b) {
		return a * b;
	}
	@Override
	public int div(int a, int b) {
		return a / b;
	}
}
