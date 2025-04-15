package chapter04_vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO {
	Scanner sc = new Scanner(System.in);
	private final DBcon db;

	public BookDAO(DBcon db) {
		this.db = db;
	}

	/* INSERT */
	public void insertData() throws SQLException {
		Book b = new Book();
		System.out.println("도서정보 작성을 시작합니다...");
		System.out.print("도서 번호를 입력하세요 >> ");
		b.setBno(sc.nextInt());
		sc.nextLine(); // 버퍼 제거
		System.out.print("도서 제목을 입력하세요 >> ");
		b.setTitle(sc.nextLine());
		System.out.print("도서 저자를 입력하세요 >> ");
		b.setAuthor(sc.nextLine());
		System.out.print("도서 출판사를 입력하세요 >> ");
		b.setPublisher(sc.nextLine());
		System.out.print("도서 가격을 입력하세요 >> ");
		b.setPrice(sc.nextInt());

		String query = "INSERT INTO bookinfo VALUES (" + b.getBno() + ",'" + b.getTitle() + "','" + b.getAuthor() + "','"
				+ b.getPublisher() + "'," + b.getPrice() + ")";
		int result = db.getStmt().executeUpdate(query);
		if(result == 1) {
			System.out.println("도서정보가 저장되었습니다...");
		}
	}

	/* SELECT */
	public void selectData() throws SQLException {
		System.out.println("도서정보 조회를 시작합니다...");
		
		List<Book> list = new ArrayList<>();
		String query = "SELECT * FROM bookinfo";
		ResultSet rs = db.getStmt().executeQuery(query);

		while (rs.next()) {
			Book b = new Book();
			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublisher(rs.getString("publisher"));
			b.setPrice(rs.getInt("price"));
			list.add(b);
		}

		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	/* UPDATE */
	public void updateData() throws SQLException {
		String s = null;
		Book b = new Book();
		System.out.println("도서정보 변경을 시작합니다...");
		System.out.print("변경을 원하는 책의 번호를 입력하세요 >> ");
		b.setBno(sc.nextInt());
		int bno = b.getBno();
		System.out.println("================================");
		System.out.println("1. 도서번호");
		System.out.println("2. 도서제목");
		System.out.println("3. 도서저자");
		System.out.println("4. 도서출판사");
		System.out.println("5. 도서가격");
		System.out.println("================================");
		System.out.print("변경을 원하는 열을 선택하세요 >> ");
		int menu = sc.nextInt();
		
		System.out.print("변경할 내용을 입력하세요 >> ");
		switch (menu) {
		case 1 -> {
			b.setBno(sc.nextInt());
			s = "bno = " + b.getBno();
		}
		case 2 -> {
			b.setTitle(sc.next());
			s = "title = '" + b.getTitle() + "'";
		}
		case 3 -> {
			b.setAuthor(sc.next());
			s = "author = '" + b.getAuthor() + "'";
		}
		case 4 -> {
			b.setPublisher(sc.next());
			s = "publisher = '" + b.getPublisher() + "'";
		}
		case 5 -> {
			b.setPrice(sc.nextInt());
			s = "price = '" + b.getPrice() + "'";
		}
		default -> System.out.println("잘못된 입력입니다...");
		}
		
		String query = "UPDATE bookinfo SET " + s + " WHERE bno = '" + bno + "'";
		int result = db.getStmt().executeUpdate(query);
		if(result == 1) {
			System.out.println("도서정보가 갱신되었습니다...");
		}
	}

	/* DELETE */
	public void deleteData() throws SQLException {
		Book b = new Book();
		System.out.println("도서정보 삭제를 시작합니다...");
		System.out.print("삭제를 원하는 도서번호를 입력하세요 >> ");
		b.setBno(sc.nextInt());
		
		String query = "DELETE FROM bookinfo WHERE bno = '" + b.getBno() +"'";
		int result = db.getStmt().executeUpdate(query);
		if(result == 1) {
			System.out.println("도서정보가 삭제되었습니다...");
		}
	}
}
