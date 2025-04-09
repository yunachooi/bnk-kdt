package chapter06;

import java.util.ArrayList;
import java.util.Scanner;

import chapter06_vo.Membership;

public class MembershipTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Membership> sList = new ArrayList<>();

		Membership m = new Membership();
		sList.add(m);

		boolean flag = true;
		while (flag) {
			System.out.println("------------");
			System.out.println("로그인하세요...");
			System.out.print("아이디와 비밀번호를 순서대로 입력하세요 >> ");
			String id = sc.next();
			String pwd = sc.next();

			for (int i = 0; i < sList.size(); i++) {
				if (sList.get(i).getId().equals(id) && sList.get(i).getPwd().equals(pwd)) {
					System.out.println("환영합니다.");
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println("아이디와 비밀번호를 확인하세요.");
			}
		}
	}
}
