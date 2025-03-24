package chapter03;

import java.util.Arrays;

public class UpperOrLower {

	public static char[] upper(char[] A) {
		for (int i = 0; i < 5; i++) {
			if (A[i] >= 97) {
				A[i] -= 32;
			}
		}
		return A;
	}

	public static char[] lower(char[] A) {	
		for (int i = 0; i < 5; i++) {
			if (A[i] < 97) {
				A[i] += 32;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		char[] A = new char[] { 'A', 'b', 'C', 'd', 'E' };

		System.out.println("대문자 >> " + Arrays.toString(upper(A)));
		System.out.println("소문자 >> " + Arrays.toString(lower(A)));
	}

}
