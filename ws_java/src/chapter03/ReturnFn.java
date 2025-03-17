package chapter03;

import java.util.Scanner;

public class ReturnFn {

	public static void f1() {
		System.out.println("f1 함수를 실행합니다.");
	}

	public static void f2() {
		System.out.println("f2 함수를 실행합니다.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("----------------");
			System.out.print("정수를 입력하세요 >> ");
			int n = sc.nextInt();

			if (n < 0) {
				System.out.println("프로그램을 종료합니다...");
				break;
			} else if (n % 2 == 0) {
				f1();
			} else {
				f2();
			}
		}

		sc.close();
	}

}
