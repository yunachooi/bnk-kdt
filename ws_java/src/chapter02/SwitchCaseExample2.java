package chapter02;

import java.util.Scanner;

public class SwitchCaseExample2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요 >> ");
		int score = sc.nextInt();
		
		switch(score / 10) {
		case 9, 10: System.out.println("A"); break;
		case 8: System.out.println("B"); break;
		case 7: System.out.println("C"); break;
		case 6: System.out.println("D"); break;
		default: System.out.println("F");
		}
		
		sc.close();
	}

}
