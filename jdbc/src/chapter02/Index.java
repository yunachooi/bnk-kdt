package chapter02;

import java.util.Scanner;

import chapter02_vo.BoardService;
import chapter02_vo.DBManager;
import chapter02_vo.MemberService;

public class Index {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		SessionStorge session = new SessionStorge();
		DBManager db = new DBManager();
		db.connect();

		MemberService memberService = new MemberService(sc, db);
		BoardService boardService = new BoardService(sc, db);

		/* 메뉴 */
		boolean flag = true;
		while (flag) {
			/* 회원가입 및 로그인 */
			System.out.println("=====메뉴=====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			/* 회원전용 */
			System.out.println("3. 게시글 등록(회원전용)");
			System.out.println("4. 전체 게시글 조회(회원전용)");
			System.out.println("5. 게시글 번호로 조회(회원전용)");
			System.out.println("6. 로그아웃");
			System.out.println("==============");
			System.out.print("번호를 선택하세요 >> ");
			int menu = sc.nextInt();
			System.out.println("==============");

			switch (menu) {
			case 1 -> memberService.register();
			case 2 -> memberService.login();
			case 3 -> {
				if (session.getUserid() == null) {
					System.out.println("회원전용 게시글 입니다."); /* 회원이 아닐 경우 */
				} else {
					boardService.writePost(memberService.getMember()); /* 회원일 경우 */
				}
			}
			case 4 -> {
				if (session.getUserid() == null) {
					System.out.println("회원전용 게시글 입니다."); /* 회원이 아닐 경우 */
				} else {
					boardService.viewAll(); /* 회원일 경우 */
				}
			}
			case 5 -> {
				if (session.getUserid() == null) {
					System.out.println("회원전용 게시글 입니다."); /* 회원이 아닐 경우 */
				} else {
					boardService.viewByNumber(); /* 회원일 경우 */
				}
			}
			case 6 -> {
				System.out.println("로그아웃되었습니다...");
				session.logout();
				flag = false;
			}
			default -> System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
