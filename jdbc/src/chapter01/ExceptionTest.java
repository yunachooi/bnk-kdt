package chapter01;

public class ExceptionTest {

	public static void main(String[] args) {
		try { //정상흐름
			int result = 10 / 0;
			System.out.println("결과 : " + result);
		} catch(ArithmeticException e) { //정상구간에서 예외상황이 발생할 수 있다라고 인지했을 때, 발생했을 경우 처리 코드
			System.out.println("0으로 나누면 안돼요...");
		}
		System.out.println("프로그램 종료 !!");
	}

}
