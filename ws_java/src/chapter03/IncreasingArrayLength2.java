package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class IncreasingArrayLength2 {
	static Scanner sc = new Scanner(System.in);

	public static int[] increasing(int[] A) {
		int[] B = new int[A.length + 5];

		B = new int[A.length + 5];

		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}

		A = B;
		return A;
	}

	public static void main(String[] args) {
		int[] A = new int[5];
		int cnt = 1;

		while(true) {
			System.out.print(cnt + ") 숫자를 입력하세요 >> ");
			A[cnt - 1] = sc.nextInt();
			
			if(A[cnt - 1] == -1) {
				A[cnt - 1] = 0;
				System.out.println("-------------------");
				System.out.println(Arrays.toString(A));
				break;
			}
			
			cnt += 1;
			
			if(A.length == cnt - 1) {
				A = increasing(A);
			}
		}

	}

}
