package week02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		
		// 랜덤 수 맞추기 게임
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int rdNum = rd.nextInt(10) + 1;
		int cnt = 0;
		int score = 0;
		int high_score = 0;
		
		int[] arr = new int[10];
		int[] num = new int[10];

		num[rdNum - 1] += 1;
		
		while (true) {
			if (cnt > 9) { // 입력 횟수 10 초과 시
				System.out.println("입력 횟수 초과로 인하여 종료합니다.");
				break;
			}
			
			System.out.print("수를 입력하세요 >> "); // 수 입력 받기
			int inputNum = sc.nextInt();
			arr[cnt] = inputNum;
			cnt += 1; // 입력 횟수 증가

			if (rdNum == inputNum) { // 두 수가 일치
				System.out.println("----------");
				System.out.println("정답입니다.");
				
				if (cnt > 0) { // 점수
					score = cnt * 10;
					score = 110 - score;
				}
				System.out.println("점수 : " + score + "점 | " + "시도 횟수 : " + cnt + "번");


				System.out.print("입력한 수 : "); // 입력한 수만큼 배열 출력
				for (int i = 0; i < 10; i++) {
					if (arr[i] != 0) {
						System.out.print(arr[i] + " ");
					}
				}
				
				System.out.println("\n게임을 계속하시겠습니까? 1. 예 2. 아니오"); // 게임 진행 여부
				int onoff = sc.nextInt();
				if (onoff == 2) { // 게임 종료
					System.out.println("----------");
					System.out.println("Game Over!");
					
					System.out.print("숫자 별 생성 횟수 : ");
					for (int i = 0; i < 10; i++) {
						if (num[i] != 0) {
							System.out.print((i + 1) + " = " + num[i] + "회   ");
						}
					}
					
					break;
				}
				else { // 게임 재진행 
					if (score > high_score) { // 최고 점수 비교
						high_score = score;
					}
					System.out.println("----------");
					System.out.println("신기록 갱신 ! 최고점수 : " + high_score + "점");
					System.out.println("----------");
					
					rdNum = rd.nextInt(10) + 1; // 초기화
					cnt = 0;
					arr = new int[10];
					score = 0;
					num[rdNum - 1] += 1;
					
					continue;
				}

			}
			else {
				if (rdNum > inputNum) { // 입력 값 비교
					System.out.println("더 큰 수를 입력하세요.");
				}
				else {
					System.out.println("더 작은 수를 입력하세요.");
				}
			}
		}
		
	}
}
