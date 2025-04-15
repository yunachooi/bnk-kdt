package chapter04;

import java.sql.SQLException;
import java.util.Scanner;

import chapter04_vo.BookDAO;
import chapter04_vo.DBcon;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		DBcon jdbc = new DBcon();
		jdbc.connect();

		BookDAO book = new BookDAO(jdbc);

		boolean flag = true;
		while (flag) {
			System.out.println("===============메뉴===============");
			System.out.println("1. 도서정보 작성");
			System.out.println("2. 도서정보 조회");
			System.out.println("3. 도서정보 갱신");
			System.out.println("4. 도서정보 삭제");
			System.out.println("5. 도서정보 종료");
			System.out.println("================================");
			System.out.print("번호를 선택하세요 >> ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1 -> book.insertData();
			case 2 -> book.selectData();
			case 3 -> book.updateData();
			case 4 -> book.deleteData();
			case 5 -> flag = false;
			default -> System.out.println("잘못된 입력입니다...");
			}
		}

	}

}
