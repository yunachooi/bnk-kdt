package chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class CharQuiz {
	static char[] temp = new char[12];
	static int cnt = 0;
	static int score = 0;

	public static char[] call(char[] str, int n) {

		for (int i = 0; i < str.length; i++) {
			if (str[i] == n) {
				temp[i] = (char) n;
				cnt += 1;
				score += 10;
			} else if (str[i] == 32) {
				temp[i] = 32;
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = new char[] { 'J', 'a', 'v', 'a', ' ', 'i', 's', ' ', 'e', 'a', 's', 'y' };
		int n = 0;

		for (int i = 0; i < str.length; i++) {
			if (str[i] != ' ') {
				temp[i] = '*';
			}
		}

		System.out.println(Arrays.toString(call(str, 0)));

		while (true) {
			if(cnt == 10) {
				System.out.println("-----------------");
				System.out.print("score >> " + score + "점");
				System.out.println("\n다 찾았습니다.");
				break;
			}
			System.out.print("\nCall Character ! >> ");
			n = sc.nextInt();

			System.out.println(Arrays.toString(call(str, n)));
		}

	}

}
