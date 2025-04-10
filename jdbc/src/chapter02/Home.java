package chapter02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter01.Member;
import chapter02_vo.Board;

public class Home {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Board> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int bno = 9;

		/*connection*/
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "green";
		String password = "1234";

		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();
		
		/* 신규회원가입 진행 */
		Member m = new Member();
		
		System.out.println("회원가입을 시작합니다...");
		System.out.print("아이디를 입력해주세요 >> ");
		m.setId(sc.next());
		System.out.print("비밀번호를 입력해주세요 >> ");
		m.setPw(sc.next());
		System.out.print("이름을 입력해주세요 >> ");
		m.setName(sc.next());
		System.out.print("전화번호를 입력해주세요 >> ");
		m.setPhone(sc.next());
		//System.out.println("test--------------------------------");
		String query = "INSERT INTO tbl_member VALUES ('" + m.getId() + "','" + m.getPw() + "','" + m.getName() + "','" + m.getPhone() + "','" + m.getGrade() + "')";
		
		stmt.executeUpdate(query);

		boolean flog = true;
		while (flog) {
			/* 메뉴 */
			System.out.println("======메뉴=====");
			System.out.println("0. 메뉴 종료");
			System.out.println("1. 게시글 등록");
			System.out.println("2. 전체 게시글 조회");
			System.out.println("3. 게시글 번호로 조회");
			System.out.println("==============");
			System.out.print("번호를 선택하세요 >> ");
			int n = sc.nextInt();
			System.out.println("==============");

			if (n == 0) {
				flog = false;
			} else if (n == 1) {
				/* 게시글 등록 */
				Board b = new Board();
				
				System.out.println("게시글 작성을 시작합니다...");
				System.out.println("게시글의 제목을 입력하시오 >> ");
				b.setTitle(sc.next());
				sc.nextLine();
				System.out.println("게시글의 내용을 입력하시오 >> ");
				b.setContent(sc.nextLine());
				
				query = "INSERT INTO tbl_board VALUES (" + ++bno + ",'" + b.getTitle() + "','" + b.getContent() + "', SYSDATE, '" + m.getId() + "')";
				stmt.executeUpdate(query);

			} else if (n == 2) {
				/* 전체 게시글 조회 */
				System.out.println("전체 게시글 조회를 시작합니다...");
				System.out.println("전체 게시글을 조회합니다.");
				
				query = "SELECT * FROM tbl_board";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					Board b = new Board();
					
					int no = rs.getInt("bno");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String regdate = rs.getString("regdate");
					String writer = rs.getString("writer");
					
					b.setBno(no);
					b.setTitle(title);
					b.setContent(content);
					b.setRegdate(regdate);;
					b.setWriter(writer);
					
					list.add(b);
				}

				for (Board board : list) {
					System.out.println(board);
				}
				

			} else if (n == 3) {
				/* 특정 게시글 번호 조회 */
				System.out.println("게시글 번호로 조회합니다.");
				System.out.print("조회를 원하는 게시글의 번호를 입력하시오 >> ");
				n = sc.nextInt();
				
				query = "SELECT * FROM tbl_board";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					Board b = new Board();
					
					int no = rs.getInt("bno");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String regdate = rs.getString("regdate");
					String writer = rs.getString("writer");
					
					b.setBno(no);
					b.setTitle(title);
					b.setContent(content);
					b.setRegdate(regdate);;
					b.setWriter(writer);
					
					list.add(b);
				}
				System.out.println(list.get(n - 1));
			}
		}
	}
}
