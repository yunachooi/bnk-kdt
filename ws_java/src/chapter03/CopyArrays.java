package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class CopyArrays {
	public static int[] allcopy(int[] A) {
		int[] B = new int[A.length];
		for(int i = 0; i < 10; i++) {
			B[i] = A[i];
		}
		return B;
	}
	
	public static int[] selectcopy(int[] A, int start, int end) {
		int[] B = new int[A.length];
		for(int i = start - 1; i < end; i++) {
			B[i] = A[i];
		}
		return B;
	}

	public static void main(String[] args) {
		int[] A = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Arrays.toString(allcopy(A)));
		
		System.out.print("시작 지점을 고르세요 >> ");
		int start = sc.nextInt();
		System.out.print("종료 지점을 고르세요 >> ");
		int end = sc.nextInt();
		System.out.println(Arrays.toString(selectcopy(A, start, end)));
	}
}