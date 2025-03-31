package chapter05;

import chapter05_vo.A;
import chapter05_vo.B;

public class ExtendsAB {

	public static void main(String[] args) {
		B b = new B();
		System.out.println("---------------");
		
		b.fA();
		System.out.println("---------------");
		
		b.fB();
		System.out.println("---------------");
		
		A ab = new B(); // 타입 불일치는 부모 타입으로 선언해서 자식 타입의 개체를 사용하는 것만 허용.
		ab.fA();
		System.out.println("---------------");
		
		B bb = (B) ab;
		bb.k = 0;
		System.out.println("bb의 K >> " + bb.k);
	}

}
