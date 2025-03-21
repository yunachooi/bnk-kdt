package chapter03;

import java.util.Scanner;

public class CharQuiz2 {
	static char[] temp = new char[12];
	static int cnt = 0;
	static int score = 0;
	
	public static char[] call(String str, int n) {

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == n) {
				temp[i] = (char) n;
				cnt += 1;
				score += 10;
			} else if (str.charAt(i) == 32) {
				temp[i] = 32;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "Java is easy";
		int n = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				temp[i] = '*';
			}
		}
		
		System.out.println(call(str, 0));

		while (true) {
			if(cnt == 10) {
				System.out.println("-----------------");
				System.out.print("score >> " + score + "점");
				System.out.println("\n다 찾았습니다.");
				break;
			}
			System.out.print("\nCall Character ! >> ");
			n = sc.nextInt();

			System.out.println(call(str, n));
		}
	}
}