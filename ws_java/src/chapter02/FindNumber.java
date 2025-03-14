package chapter02;

import java.util.Random;
import java.util.Scanner;

public class FindNumber {

	public static void main(String[] args) {

		// 랜덤으로 있는 1을 찾아라 게임
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[5][5];
		int cnt = 0;
		int try_cnt = 0;

		for (int i = 0; i < 5; i++) {
			int col = rd.nextInt(5);
			board[i][col] = 1;
		}

		while(cnt < 5) {
			System.out.println("--------------------");
			System.out.print("행을 입력하세요 >> ");
			int inputrow = sc.nextInt();
			System.out.print("열을 입력하세요 >> ");
			int inputcol = sc.nextInt();
			try_cnt += 1;
			
			if (board[inputrow - 1][inputcol - 1] == 1) {
				System.out.println("맞았습니다!");
				cnt += 1;

			} else {
				System.out.println("틀렸습니다.");
			}
		}
		System.out.println("--------------------");
		System.out.println("시도 횟수 >> " + try_cnt + "회");
		
		sc.close();
	}

}
