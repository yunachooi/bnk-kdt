package chapter04_vo;

public class HumanCamp2 {
	private int speed = 10;
	
	public Unit getMarine() {
		class Marine2 implements Unit{

			@Override
			public void move() {
				System.out.printf("인간형 유닛이 %d 속도로 이동합니다.", speed);
			}
			
		}
		return new Marine2();
	}
}
