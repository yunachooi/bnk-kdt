package chapter04_vo;

import lombok.Data;

@Data
public class Outer1 {
	private int speed = 10;
	
	public class MemberInner1{
		//외부클래스에서는 아예 필요가 없다고 판단될 경우 내부클래스로 생성하여 사용함.
		//멤버변수로 처리하지 않고, 의미있는 단위로 묶어서 처리하고자 클래스로 묶음.
		//제약없이 사용 가능.
		public void move() {
			System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
		}
	}
	public void getUnit(){
		MemberInner1 inner = new MemberInner1();
		inner.move();
	}
}
