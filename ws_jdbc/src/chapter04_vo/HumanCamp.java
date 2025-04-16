package chapter04_vo;

public class HumanCamp {
	private int speed = 10;
	
	public void getMarine() {
		//내부클래스를 한 번 더 감싸게 되면, 더이상 외부에서는 접근이 안됨. 내부의 메서드에서만 접근 가능.
		//익명클래스라 명칭
		class Marine{
			public void move() {
				System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n", speed);
			}
		}
		
		Marine inner = new Marine();
		inner.move();
	}
}