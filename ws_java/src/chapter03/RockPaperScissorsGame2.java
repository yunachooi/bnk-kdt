package chapter03;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame2 {

	// 전적 전역 변수
	static int draw = 0;
	static int lose = 0;
	static int win = 0;

	// 랜덤 값 생성
	public static int randomNumber() {
		Random rd = new Random();
		int rdNum = rd.nextInt(3) + 1;

		return rdNum;
	}

	// 사용자 값 입력
	public static int inputNumber() {
		Scanner sc = new Scanner(System.in);

		System.out.print("가위(1)-바위(2)-보(3) >> ");
		int rsp = sc.nextInt();

		return rsp;
	}

	// 가위바위보 승패 판별
	public static void judge() {
		while (true) {
			int com = randomNumber();
			int user = inputNumber();

			// 게임 종료 및 전적 출력
			if (user < 0) {
				System.out.println("게임을 종료합니다.");
				System.out.println("전적 >> " + win + "승  " + draw + "무  " + lose + "패  ");
				System.out.println("---------------");
				break;
			}

			// 게임 결과 출력 및 전적 갱신
			int result = com - user;

			if (result == 0) {
				System.out.println("무승부!");
				draw += 1;
			} else if (result == -1 || result == 2) {
				System.out.println("user 승리!");
				win += 1;
			} else {
				System.out.println("computer 승리!");
				lose += 1;
			}
			System.out.println("---------------");
		}

	}

	public static void main(String[] args) {
		judge();
	}
}
