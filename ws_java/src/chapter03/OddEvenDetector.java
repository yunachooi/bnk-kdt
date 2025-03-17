package chapter03;

import java.util.Scanner;

public class OddEvenDetector {
	public static int detector(int a) {
		if(a % 2 == 0) {
			return 0;
		}
		else{
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("----------------");
			System.out.print("정수를 입력하세요 >> ");
			int n = sc.nextInt();
			
			if(n < 0) {
				System.out.println("종료합니다.");
				break;
			}
			else if(detector(n) == 0) {
				System.out.println("짝수 입니다.");
			}
			else {
				System.out.println("홀수 입니다.");
			}
		}
		
		sc.close();
	}

}
