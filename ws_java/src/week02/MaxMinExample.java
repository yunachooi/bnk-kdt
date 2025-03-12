package week02;

import java.util.Arrays;

public class MaxMinExample {

	public static void main(String[] args) {
		
		// 변수 연습
		int n1 = 10;
		int n2 = 20;
		int n3 = 30;
		int sum;
		
		System.out.println("n1에 저장된 값 >> " + n1);
		System.out.println("n2에 저장된 값 >> " + n2);
		System.out.println("n3에 저장된 값 >> " + n3);
		sum = n1 + n2 + n3;
		System.out.println("세 수의 합 >> " + sum);
		
		if (sum >= 60) {
			System.out.println("sum은 60이상 입니다.");
		} else {
			System.out.println("sum은 60미만 입니다.");
		}
		
		if (sum % 2 == 0) {
			System.out.println("sum은 짝수입니다.");
		} else {
			System.out.println("sum은 홀수입니다.");
		}
		
		
		// 배열 연습
		int[] arr = new int[] {0, 1, 2, 3, 4};
		arr[2] = n1;
		arr[4] = sum;
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < 5; i++) {
			System.out.print("arr[" + i + "] >> " + arr[i] + "  ");
		}
		for (int i = 0; i < 5; i++) {
			sum += arr[i];
		}
		System.out.println();
		System.out.println("sum >> " + sum);
		
		// 배열 연습 2
		int[] A = new int[] {1, 11, 3, 4, 5, 6, 7, 8, 9, 10};
		int max, min, mul = 0, sum2 = 0;
		double evg = 0.0;
		
		// 최대값 구하기
		max = A[0];
		for (int i = 0; i < 10; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		System.out.println("max : " + max);
		
		// 최소값 구하기
		min = A[0];
		for (int i = 0; i < 10; i++) {
			if (A[i] < min) {
				min = A[i];
			}
		}
		System.out.println("min : " + min);
		
		// 3배수의 개수
		for (int i = 0; i < 10; i++) {
			if (A[i] % 3 == 0) {
				mul += 1;
			}
		}
		System.out.println("mul : " + mul);
		
		// 총합 구하기
		for (int i = 0; i < 10; i++) {
			sum2 += A[i];
		}
		System.out.println("sum : " + sum2);
		
		// 평균 구하기
		for (int i = 0; i < 1; i++) {
			evg = sum2 / 10;
		}
		System.out.println("evg : " + evg);
	}

}
