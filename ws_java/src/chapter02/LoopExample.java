package chapter02;

public class LoopExample {

	public static void main(String[] args) {

		// continue : 이 후의 명령문은 건너뛰고 다시 블록의 처음으로 이동 (Jump)
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println(i);
		}
		
		int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {
			if (A[i] % 2 == 1) {
				continue;
			}
			sum += A[i];
		}
		System.out.println("sum >> " + sum);
	}

}
