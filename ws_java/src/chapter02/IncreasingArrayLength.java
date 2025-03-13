package chapter02;

import java.util.Arrays;
import java.util.Scanner;

public class IncreasingArrayLength {

	public static void main(String[] args) {

		// 배열 길이가 늘어나는 배열
		Scanner sc = new Scanner(System.in);
		int[] A = new int[3];
		int[] B = new int[A.length + 1];

		System.out.println("숫자를 입력하세요 >> ");
		for (int i = 0; i < 3; i++) { // A 배열 생성
			A[i] = sc.nextInt();
		}
		
		while(true) {
			B = new int[A.length + 1];
			
			for (int i = 0; i < A.length; i++) { // A 배열과 B 배열에 동일한 값 복사
				B[i] = A[i];
			}

			A = B; // B 배열의 주소 값을 A 배열로 바꾸기
			
			System.out.println("------------------------------------");
			System.out.print("추가할 값 (종료 시 -1을 입력하세요) >> "); // B 배열 생성
			A[A.length - 1] = sc.nextInt();
			
			if (A[A.length - 1] == -1) {
				System.out.println("\n종료합니다.");
				break;
			}

			System.out.println(Arrays.toString(A));
		}
		
		sc.close();
	}

}
