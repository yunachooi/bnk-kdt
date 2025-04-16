package chapter04;

import chapter04_vo.Unit2;

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
		
		/* 방법3-1. 멤버변수가 하나 일 경우 */
//		람다식 : 인터페이스에 메서드가 하나일 경우에 아래와 같은 방식으로 호출 가능
//		Unit2 unit = s -> System.out.println(s);
//		unit.move("인간이 움직인다구요...");
		
		/* 방법3-2. 멤버변수가 하나 이상일 경우 */
//		Unit2 unit = (s, n) -> {
//			System.out.println(s);
//			System.out.println(n);
//		};
//		unit.move("인간이 움직인다구요...", 1);
		
		/* 방법4. */
		Unit2 unit = s -> s.length(); //return 값이 없더라도 return이 된 것.
		
		int result = unit.move("인간이 움직인다구요...");
		System.out.println("move의 길이 >> " + result);
		
	}
}
