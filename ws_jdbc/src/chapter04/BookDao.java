package chapter04;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter04_vo.Book;
import chapter04_vo.DBcon;

public class BookDao {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

	public BookDao(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

	/* INSERT */
	public void insertInfo() throws SQLException, ClassNotFoundException {
		Book b = new Book();
		System.out.println("도서정보 작성을 시작합니다...");
		System.out.print("도서 번호를 입력하세요 >> ");
		b.setBno(sc.nextInt());
		sc.nextLine(); // 버퍼 제거
		checkBno(b);
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
	
	public void checkBno(Book b) throws ClassNotFoundException, SQLException {
		String query = "SELECT * FROM bookinfo WHERE bno = ?";
		PreparedStatement pstmt = db.connect().prepareStatement(query);
		pstmt.setInt(1, b.getBno());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			System.out.println("이미 존재하는 도서 번호입니다...");
		}
		else {
			System.out.println("사용 가능한 도서 번호입니다...");
		}
	}
	
	/* SELECT */
	public void viewAll() throws SQLException, ClassNotFoundException {
		System.out.println("도서정보 조회를 시작합니다...");

		List<Book> list = new ArrayList<>();
		String query = "SELECT * FROM bookinfo";
		pstmt = db.connect().prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Book b = new Book();
			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublisher(rs.getString("publisher"));
			b.setPrice(rs.getInt("price"));
			list.add(b);
		}

		System.out.println("<< 도서목록 >>");
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	/* SELECT2 */
	public void viewTitle() throws SQLException, ClassNotFoundException {
		System.out.println("도서정보 조회를 시작합니다...");
		System.out.println("찾는 도서의 제목을 입력하세요 >> ");
		String t = sc.next();
		t = "%" + t + "%";
		
		String query = "SELECT * FROM bookinfo WHERE title Like ?";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setString(1, t);
		ResultSet rs = pstmt.executeQuery();
		
		System.out.println("<< 도서목록 >>");
		int flag = 0;
		while(rs.next()) {
			Book b = new Book();
			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setAuthor(rs.getString("author"));
			b.setPublisher(rs.getString("publisher"));
			b.setPrice(rs.getInt("price"));
			System.out.println(b);
			flag = 1;
		}
		if (flag == 0) {
			System.out.println("해당 도서가 존재하지 않습니다...");
		}
	}

	/* UPDATE */
	public void updateInfo() throws SQLException, ClassNotFoundException {
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

		if (choice == 1 || choice == 5) {
			System.out.println("수정할 내용을 입력하세요 >> ");
			ivalue = sc.nextInt();
		} else {
			System.out.println("수정할 내용을 입력하세요 >> ");
			svalue = sc.next();
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
	public void deleteInfo() throws SQLException, ClassNotFoundException {
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
