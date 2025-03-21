package chapter03;

import java.util.Scanner;

public class VendingMachine {
	static Scanner sc = new Scanner(System.in);

	// 사용자가 물건을 받는다.
	public static void goods() {
		System.out.println("상품을 받으세요!");
	}

	// 사용자가 거스름 돈을 받는다.
	public static void change(int money) {

		System.out.println("----------------------");
		if (money == 0) {
			System.out.println("거스름돈이 없습니다.");
			goods();
		} else if (money >= 500) {
			System.out.println("상품을 더 뽑으시겠습니까? Y:1 >> ");
			int ans = sc.nextInt();

			if (ans == 1) {
				selection(money);
			} else {
				System.out.println("거스름돈 " + money + "원을 반환합니다.");
				goods();
			}
		} else {
			System.out.println("거스름돈 " + money + "원을 반환합니다.");
			goods();
		}

	}

	// 사용자가 상품 가격이 명시된 상품을 선택한다.
	public static void selection(int money) {
		// 최소 금액 받기
		while (true) {
			if (money < 500) {
				money += inputMoney();
			} else {
				break;
			}
		}

		if (money >= 1000) {
			System.out.println("----------------------------");
			System.out.println("1. 아이스생수 500원 (가능)");
			System.out.println("2. 탄산음료 500원 (가능)");
			System.out.println("3. 이온음료 1,000원 (가능)");
			System.out.println("4. 오렌지주스 1,000원 (가능)");
			System.out.println("----------------------------");
		} else {
			System.out.println("----------------------------");
			System.out.println("1. 아이스생수 500원 (가능)");
			System.out.println("2. 탄산음료 500원 (가능)");
			System.out.println("----------------------------");
		}

		// 상품 선택
		System.out.print("구매를 원하는 음료의 번호를 고르세요 >> ");
		int n = sc.nextInt();

		if (n == 1 || n == 2) {
			if (money >= 500) {
				change(money - 500);
			}
		}

		else if (n == 3 || n == 4) {
			if (money >= 1000) {
				change(money - 1000);
			} else {
				while (true) {
					if (money < 1000) {
						System.out.println((1000 - money) + "원이 모자랍니다. 더 투입하세요.");
						money += inputMoney();
					} else {
						selection(money);
						break;
					}
				}
			}
		}
	}

	// 사용자가 금액을 투입한다.
	public static int inputMoney() {
		System.out.print("금액을 투입하세요. >> ");
		int money = sc.nextInt();

		return money;
	}

	public static void main(String[] args) {
		System.out.println("----------------------------");
		System.out.println("1. 아이스생수 500원");
		System.out.println("2. 탄산음료 500원");
		System.out.println("3. 이온음료 1,000원");
		System.out.println("4. 오렌지주스 1,000원");
		System.out.println("----------------------------");

		selection(inputMoney());
	}
}
