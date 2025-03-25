package chapter03;

import chapter04.A; // 외부 패키지

public class ATest2 {

	public static void main(String[] args) {
		A a = new A();
		a.n = 10;
		System.out.println(a.n);
	}

}
