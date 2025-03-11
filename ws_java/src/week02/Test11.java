package week02;

import java.util.Random;
import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {

		// 가위바위보 게임
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int c_cnt = 0, u_cnt = 0, d_cnt = 0;
		int cnt = 0;
		int max = 0, max_i = 1;
		int[] arr = new int[3];

		while (true) {
			int rdNum = rd.nextInt(3) + 1; // 입력
			System.out.println("[가위 : 1 | 바위 : 2 | 보 : 3]");
			System.out.print("computer가 낼 수를 추천 받으시겠습니까? (Y:1/N:2) >> "); // 값 추천 받기
			int r = sc.nextInt();

			if (r == 1) {
				for (int i = 0; i < 3; i++) {
					if (arr[i] > max) {
						max = arr[i];
						max_i = i + 1;
					}
				}
				System.out.println("예상 : " + max_i);
				System.out.println("---------------------------");
			}

			System.out.print("user >> ");
			int rsp = sc.nextInt();

			arr[rdNum - 1] += 1; // computer 낸 수

			if (rsp != 1 && rsp != 2 && rsp != 3) {
				System.out.println("다시 입력하세요.");
				System.out.println("---------------------------");
				continue;
			}

			System.out.println("com >> " + rdNum); // computer 결과 출력
			System.out.println("---------------------------");

			cnt += 1;
			int result = rdNum - rsp;
			System.out.println(result);

			if (result == 0) { // 승리여부
				System.out.println("무승부!");
				d_cnt += 1; // 무승부
			} else if (result == -1 || result == 2) {
				System.out.println("user 승리!");
				c_cnt += 1; // 패배
			} else {
				System.out.println("computer 승리!");
				u_cnt += 1; // 승리
			}

			System.out.print("계속할래?(Y:1/N:2) >> "); // 재게임 여부
			int ans = sc.nextInt();

			if (ans == 2) { // 게임 종료
				System.out.println("---------------------------");
				System.out.println("게임을 종료합니다.");
				System.out.println("게임 횟수 >> " + cnt + "회");
				System.out.println("전적 >> [승 : " + u_cnt + "]  [무 : " + d_cnt + "]  [패 : " + c_cnt + "]");
				break;
			} else if (ans == 1) { // 재게임
				System.out.println("---------------------------");
				continue;
			} else { // 오류
				System.out.println("잘못 입력하였습니다.");
				System.out.println("게임을 종료합니다.");
				break;
			}
		}
		sc.close();
	}

}
