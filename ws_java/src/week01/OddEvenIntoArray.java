package week01;

import java.util.Random;
// import java.util.Arrays;

public class OddEvenIntoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// random을 통해 수를 받은 후 홀, 짝수 개수를 구한 후에 그에 맞는 배열 생성
		Random rd = new Random();
		int[] arr = new int [5];
		int[] a = new int[5];
		int[] b = new int[5];
		int aidx = 0;
		int bidx = 0;

		for (int i = 0; i < 5; i++) {
			int rdNum = rd.nextInt(9) + 1;
			
			arr[i] = rdNum;
		}
		
		for (int i = 0; i < 5; i++) {
			a[i] = 0;
			b[i] = 0;
		}

		for (int i = 0; i < 5; i++) {
			if (arr[i] % 2 == 0) {
				a[aidx] = arr[i];
				aidx = aidx + 1;
			}
			else {
				b[bidx] = arr[i];
				bidx = bidx + 1;
			}
		}
		
		// System.out.println("짝수 = " + Arrays.toString(a));
		// System.out.println("홀수 = " + Arrays.toString(b));
		
		System.out.print("짝수 = ");
		for (int i = 0; i < 5; i++) {
			if (a[i] != 0) {
				System.out.print(a[i] + " ");
			}
		}
		
		System.out.println();
		
		System.out.print("홀수 = ");
		for (int i = 0; i < 5; i++) {
			if (b[i] != 0) {
				System.out.print(b[i] + " ");
			}
		}
	}
}
