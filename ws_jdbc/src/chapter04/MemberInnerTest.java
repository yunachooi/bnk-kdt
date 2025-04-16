package chapter04;

import chapter04_vo.Outer1;

public class MemberInnerTest {

	public static void main(String[] args) {
		Outer1 out = new Outer1();
		
		out.getUnit();
		
		Outer1.MemberInner1 inner = out.new MemberInner1();
		//out.new 생성자는 내부클래스이기에 외부클래스를 거쳐서 만듦.
		inner.move();
	}

}
