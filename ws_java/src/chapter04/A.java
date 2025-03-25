package chapter04;

public class A { // class : 자료(data) + 기능
	public int n; // 접근 제한자 public
	String s;
	
	void f() {
		System.out.println(n + ", " + s);
	}
	int f2() {
		return n; // 전역변수
	}
}
