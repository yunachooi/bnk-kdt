package chapter02;

import java.util.Arrays;
import java.util.Scanner;

public class HotelReservationSystem {

	public static void main(String[] args) {

		// 호텔 방 예약하는 시스템
		Scanner sc = new Scanner(System.in);
		int[] room = new int[10];
		int sum = 0;

		while (true) {
			System.out.println("--------------------------------------------");

			if (sum == 10) { // 만실
				System.out.println("만실입니다.");
				break;
			} else {
				System.out.println("아직 방이 남아있어요.");
			}

			System.out.print("예약하시겠습니까 (Y:1/N:2) >> ");
			int ans = sc.nextInt();

			if (ans == 1) { // 예약 시작
				System.out.print("몇 번 방을 예약하시겠습니까? >> ");
				int rsvd = sc.nextInt();

				if (room[rsvd - 1] == 1) { // 이미 예약된 방
					System.out.println("--------------------------------------------");
					System.out.println("이 방은 이미 예약되어있습니다.");
					System.out.println("다른 방을 선택해주세요.");
					continue;
				} else { // 예약 완료
					System.out.println("--------------------------------------------");
					System.out.println(rsvd + "번 방이 예약되었습니다.");
					room[rsvd - 1] = 1;

					System.out.println("예약 현황 >> " + Arrays.toString(room)); // 예약 현황

					sum += 1;
				}
			}

			else if (ans == 2) { // 예약 서비스 종료
				System.out.println("--------------------------------------------");
				System.out.println("예약 서비스를 종료합니다.");
				break;
			}

			else { // 오입력
				System.out.println("--------------------------------------------");
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
				continue;
			}

		}
		sc.close();
	}

}
