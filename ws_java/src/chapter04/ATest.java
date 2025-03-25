package chapter04;

public class ATest {

	public static void main(String[] args) {
		A a = new A(); // 명세(A)가 실제로 메모리 상에 존재
		
		a.n = 5;
		a.s = "Hello";
		
		a.f();
		System.out.println(a.f2());
	}

}
