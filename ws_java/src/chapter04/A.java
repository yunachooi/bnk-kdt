package chapter04;

public class A { // class : 자료(data) + 기능
	int n;
	String s;
	
	void f() {
		System.out.println(n + ", " + s);
	}
	int f2() {
		return n; // 전역변수
	}
}
