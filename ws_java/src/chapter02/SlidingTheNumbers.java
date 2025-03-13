package chapter02;

import java.util.Scanner;

public class SlidingTheNumbers {

	public static void main(String[] args) {

		// 숫자를 입력 받은 후에 그 수를 슬라이싱해서 합을 구하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int n1 = n, cnt = 1, sum = 0;

		while ((n1 / 10) != 0) {
			n1 /= 10;
			cnt += 1;
		}
		
		int[] arr = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			arr[i] += n % 10;
			n /= 10;
		}

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		System.out.println(sum);

		sc.close();
	}

}
