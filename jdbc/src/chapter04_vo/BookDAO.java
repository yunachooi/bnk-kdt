package chapter04_vo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

	public BookDAO(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

	/* INSERT */
	public void insertData() throws SQLException, ClassNotFoundException {
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

		String query = "INSERT INTO bookinfo VALUES (?, ?, ?, ?, ?)";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setInt(1, b.getBno());
		pstmt.setString(2, b.getTitle());
		pstmt.setString(3, b.getAuthor());
		pstmt.setString(4, b.getPublisher());
		pstmt.setInt(5, b.getPrice());

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("도서정보가 저장되었습니다...");
		}
	}

	/* SELECT */
	public void selectData() throws SQLException, ClassNotFoundException {
		System.out.println("도서정보 조회를 시작합니다...");

		List<Book> list = new ArrayList<>();
		String query = "SELECT * FROM bookinfo";
		pstmt = db.connect().prepareStatement(query);
		ResultSet rs = pstmt.executeQuery(query);

		while (rs.next()) {
			Book b = new Book();
			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublisher(rs.getString("publisher"));
			b.setPrice(rs.getInt("price"));
			list.add(b);
		}

		System.out.println("<< 도서목록 조회 화면 >>");
		for (Book book : list) {
			System.out.println(book);
		}
	}

	/* UPDATE */
	public void updateData() throws SQLException, ClassNotFoundException {
		Book b = new Book();
		int ivalue = 0;
		String svalue = null;
		System.out.println("도서정보 변경을 시작합니다...");
		System.out.print("변경을 원하는 책의 번호를 입력하세요 >> ");
		b.setBno(sc.nextInt());
		int bno = b.getBno();
		System.out.print("수정할 항목을 선택하세요 (1. 도서번호, 2. 도서제목, 3. 도서저자, 4. 도서출판사, 5. 도서가격) >> ");
		int choice = sc.nextInt();

		String items = switch (choice) {
		case 1 -> "bno";
		case 2 -> "title";
		case 3 -> "author";
		case 4 -> "publisher";
		case 5 -> "price";
		default -> null;
		};

		System.out.println("수정할 내용을 입력하세요 >> ");
		if (choice == 1 || choice == 5) {
			ivalue = sc.nextInt();
		} else {
			svalue = sc.nextLine();
		}

		String query = "UPDATE bookinfo SET " + items + " = ? WHERE bno = ?";
		pstmt = db.connect().prepareStatement(query);
		if (choice == 1 || choice == 5) {
			pstmt.setInt(1, ivalue);
		} else {
			pstmt.setString(1, svalue);
		}
		pstmt.setInt(2, bno);

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("도서정보가 갱신되었습니다...");
		}
	}

	/* DELETE */
	public void deleteData() throws SQLException, ClassNotFoundException {
		Book b = new Book();
		System.out.println("도서정보 삭제를 시작합니다...");
		System.out.print("삭제를 원하는 도서번호를 입력하세요 >> ");
		b.setBno(sc.nextInt());

		String query = "DELETE FROM bookinfo WHERE bno = ?";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setInt(1, b.getBno());

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("도서정보가 삭제되었습니다...");
		}
	}
}
