package ex01;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// println 과 print 출력 차이
		System.out.println("Hello Java!"); // 개행 O
		System.out.print("Hello Java!"); // 개행 X 
				
				
		// a + b 더하기
		int a = 1;
		int b = 2;
		int c = a + b;
				
		System.out.println(c);
		System.out.println(a + b);
				
				
		// 짝수, 홀수 판별하기
		int n = 3;
		String result;
				
		if (n % 2 == 0) {
			result = "짝수";
		}
		else {
			result = "홀수";
		}
				
		System.out.println(result);
				
				
		// 두 개의 숫자 중 큰 수, 작은 수, 같은 수 인지 비교
		int n1 = 1;
		int n2 = 1;
				
		if (n1 == n2) {
			System.out.println("첫 번째 값과 두 번째 값이 같다");
		}
		else if (n1 > n2) {
			System.out.println("첫 번째 값이 더 크다");
		}
		else {
			System.out.println("두 번째 값이 더 크다");
		}
				
				
		// while 조건문을 사용하여 "Hello" 5번 출력하기
		int m = 0;
				
		while (m < 5) {
			System.out.println("Hello");
			m = m + 1;
		}
	}

}
