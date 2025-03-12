package week01;

public class SumExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1부터 10까지 누계
		int sum = 0;
				
		for (int i = 0; i <= 10; i++) {
			sum = sum + i;
		}
		
		System.out.println(sum);
				
				
		// 1부터 100까지 홀수 누계
		int sum2 = 0;
				
		for (int i = 1; i < 100; i = i + 2) {
			sum2 = sum2 + i;
		}
				
		System.out.println(sum2);
				
				
		// 1/2 + 2/3 + 4/3 ... 49/50 분수의 누계
		float sum3 = 0;
		float n = 1;

		while (n < 50) {
			sum3 = sum3 + (n / (n + 1));
			n += 1;
		}
				
		System.out.printf("%.2f\n", sum3);
	}
}
