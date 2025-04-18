package chapter04;

interface Scale {
	// 상수에 대한 변수명을 선언할 경우 대문자로 표시
	// 해당 인터페이스는 상수의 집합
	// public, static, final이 생략된 것처럼 보임 (실제로는 구현됨)
	int DO = 0; int RE = 1; int MI = 2; int FA = 3;
	int SO = 4; int RA = 5; int TI = 6;
}

public class InterfaceBaseConstTest {

	public static void main(String[] args) {
		int sc = Scale.DO;

		switch (sc) {
		case Scale.DO:
			System.out.println("도");
			break;
		case Scale.RE:
			System.out.println("레");
			break;
		case Scale.MI:
			System.out.println("미");
			break;
		case Scale.FA:
			System.out.println("파");
			break;
		case Scale.SO:
			System.out.println("솔");
			break;
		case Scale.RA:
			System.out.println("라");
			break;
		case Scale.TI:
			System.out.println("시");
			break;
		}

	}

}
