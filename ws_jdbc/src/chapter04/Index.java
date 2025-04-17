package chapter04;

import java.sql.SQLException;
import java.util.Scanner;

import chapter04_vo.DBcon;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		DBcon jdbc = new DBcon();
		jdbc.connect();

		BookDao book = new BookDao(sc, jdbc);

		boolean flag = true;
		while (flag) {
			System.out.println("""
	                ===============메뉴===============
	                1. 도서정보 작성
	                2. 도서정보 조회
	                3. 도서제목 조회
	                4. 도서정보 갱신
	                5. 도서정보 삭제
	                6. 도서정보 종료
	                ================================
	                """);
			System.out.print("번호를 선택하세요 >> ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1 -> book.insertInfo();
			case 2 -> book.viewAll();
			case 3 -> book.viewTitle();
			case 4 -> book.updateInfo();
			case 5 -> book.deleteInfo();
			case 6 -> {
				flag = false;
				System.out.println("도서정보 시스템을 종료합니다...");
			}
			default -> System.out.println("잘못된 입력입니다...");
			}
		}

	}

}
