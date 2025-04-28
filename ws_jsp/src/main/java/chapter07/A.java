package chapter07;

public class A {
	private static A instance = new A();
	
	private A() {}
	
	public static A getInstance() {
		return instance;
	}
}
