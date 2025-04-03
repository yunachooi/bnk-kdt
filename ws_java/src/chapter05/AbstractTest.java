package chapter05;

import chapter05_vo.AbstractA;

public class AbstractTest {

	public static void main(String[] args) {
		// 자식 입장에서 내가 생성될 때 부모 생성자 호출 시 super 키워드를 사용.
		// 추상클래스에는 완성된 메소드 또는 미완성된 메소드 가능.
		AbstractA a = new AbstractA(100);
		System.out.println(a.getN());
	}

}