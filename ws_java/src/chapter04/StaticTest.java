package chapter04;

import chapter04_vo.Static;

public class StaticTest {

	public static void main(String[] args) {
		Static a = new Static(); // 인스턴스 필요
		a.n = 10;
		System.out.println(a.n);

		Static.x = 30; // 인스턴스 불필요, 클래스에 속해있음
		System.out.println(Static.x);

		Static b = new Static();
		b.nonStaticF();
		
		Static.staticF();

	}
}