package week02;

import java.util.Arrays;

public class ValuesIntoArray {
	public static void main(String[] args) {

		// 3개 공간의 배열 안에 10을 10번 넣기
		int[] A = new int[3];
		int[] B = new int[A.length + 1];

		for (int i = 0; i < 10; i++) {
			if (A.length > i) {
				A[i] = 10;
			} else {
				B = new int[A.length + 1];

				for (int j = 0; j < A.length; j++) { // A 배열과 B 배열에 동일한 값 복사
					B[j] = A[j];
				}

				A = B; // B 배열의 주소 값을 A 배열로 바꾸기

				A[i] = 10;
			}
			System.out.println(Arrays.toString(A));
		}
	}
}
