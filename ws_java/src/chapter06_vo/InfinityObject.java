package chapter06_vo;

import java.util.Arrays;

class A {
	private int n;
	private String s;

	public A(int n, String s) {
		this.n = n;
		this.s = s;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}

class B {
	private float f;
	private char c;

	public B(float f, char c) {
		this.f = f;
		this.c = c;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
}

public class InfinityObject {

	public static void main(String[] args) {
		// Object 의 성격 알기 - Object 클래스는 모든 클래스의 부모이다.
		// 상속 관계에서 자식들은 타입이 다를 수 있음.
		// 타입이 다르다는 것은 배열을 만들 수 없다는 것을 의미.
		// 부모타입으로 선언한 배열에 자식 타입들이 들어갈 수 있음.
		// 결과적으로 상속관계는 부모타입으로 서로 다른 자식 타입을 하나로 묶을 수 있다는 뜻.

		Object[] objs = new Object[3];

		objs[0] = "hello";
		objs[1] = new A(1, "James");
		objs[2] = new B(2.3f, 'B');

		Object[] temp = new Object[objs.length + 3];

		for (int i = 0; i < objs.length; i++) {
			temp[i] = objs[i];
		}
		objs = temp;

		objs[3] = "Good";
		objs[4] = new A(2, "Ann");
		objs[5] = new B(3.3f, 'C');

		System.out.println(Arrays.toString(objs));

	}

}
