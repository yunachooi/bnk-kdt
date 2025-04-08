package chapter06;

import chapter06_vo.X;
import chapter06_vo.Y;

public class XY {

	public static void main(String[] args) {
		X a = new X();
		Y b = new Y();
		X a1 = new Y();
		// y 변수도 사용할 수 있도록 형변환 필요.
		Y b1 = (Y)a1;
		
		a.x = 10;
		b.y = "hello";
		a1.x = 20;
		b1.y = "bye";
		
		
		System.out.println(a.x);
		System.out.println(b.y);
		System.out.println(a1.x);
		System.out.println(b1.y);
	}

}
