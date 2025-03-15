package chapter02;

import java.util.Random;
import java.util.Scanner;

public class FindNumber2 {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[5][5];
		int row, col, cnt = 0;

		for (int i = 0; i < 5; i++) {
			row = rd.nextInt(5);
			col = rd.nextInt(5);
			
			if(board[row][col] == 1) {
				i--;
				continue;
			}
			board[row][col] = 1;

		}
		
		System.out.println("보물 5개의 위치를 찾아보세요 !");
		
		while(true) {
			System.out.println("--------------------");
			System.out.print("행을 입력하세요 >> ");
			int rown = sc.nextInt();
			System.out.print("열을 입력하세요 >> ");
			int coln = sc.nextInt();
			
			if(board[rown - 1][coln - 1] == 1) {
				cnt += 1;
				board[rown - 1][coln - 1] = 0;
				
				System.out.println("찼았습니다!");
				
				if(cnt == 5) {
					System.out.println("--------------------");
					System.out.println("보물 5개를 다 찾았습니다.");
					System.out.println("게임을 종료합니다.");
					System.out.println("--------------------");
					break;
				}
				
				System.out.println((5 - cnt) + "개 남았습니다.");
			}
			else {
				System.out.println("틀렸습니다.");
			}
		}
		
		sc.close();
	}

}
