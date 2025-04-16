package chapter04;

import chapter04_vo.Unit;

public class LambdaTest1 {

	public static void main(String[] args) {
		/* 방법1 */
//		Unit unit = new Human();
//		unit.move();
		
		/* 방법2 */
//		Unit unit = new Unit() { //익명 클래스
//
//			@Override
//			public void move() {
//				System.out.println("인간이 움직인다구요...");
//			}
//			
//		};
//		unit.move();
		
		/* 방법3 */
		Unit unit = () -> {
			System.out.println("인간이 움직인다구요...");
		};
		unit.move();
		
	} //End of Main
}
