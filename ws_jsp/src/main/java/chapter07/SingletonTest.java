package chapter07;

public class SingletonTest {
	public static void main(String[] args) {
		A a = A.getInstance();
		
		A b = A.getInstance();
		
		System.out.println(a == b);
		
		B c = new B();
		B d = new B();
		
		System.out.println(c == d);
	}
}
