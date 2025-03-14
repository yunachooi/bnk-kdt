package chapter02;

import java.util.Scanner;

public class StudentScore {

	public static void main(String[] args) {

		// 학생들의 성적 합계 및 과목 별 성적 합계
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[4][4];
		
		// 성적 입력
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					System.out.print((i + 1) + "번 학생의 국어 성적을 입력하세요 >> ");
					board[i][j] = sc.nextInt();
				}
				else if(j == 1) {
					System.out.print((i + 1) + "번 학생의 수학 성적을 입력하세요 >> ");
					board[i][j] = sc.nextInt();
				}
				else {
					System.out.print((i + 1) + "번 학생의 영어 성적을 입력하세요 >> ");
					board[i][j] = sc.nextInt();
				}
			}
			System.out.println("----------------------------------");
		}
		
		// 학생 별 성적 합계
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][3] += board[i][j];
			}
		}
		
		// 과목 별 성적 합계
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[3][j] += board[i][j];
			}
		}
		
		for(int i = 0; i < 4; i++) {
			System.out.println("----------------------------------");
			if(i == 3) {
				System.out.println("# 과목별 합계");
				System.out.println("국어\t수학\t영어");
			}
			else {
				System.out.println("# " + (i + 1) + "번 학생");
				System.out.println("국어\t수학\t영어\t점수합계");
			}
			
			for(int j = 0; j < 4; j++) {
				if(board[i][j] == 0) {
					continue;
				}
				System.out.print(board[i][j] + "점\t");
			}
			System.out.println();
		}
		sc.close();
		
	}

}
