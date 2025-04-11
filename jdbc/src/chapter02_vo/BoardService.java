package chapter02_vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chapter02.SessionStorge;

public class BoardService {
	private final Scanner sc;
	private final DBManager db;
	private SessionStorge session = new SessionStorge();
	private int bno = 9;

	public BoardService(Scanner sc, DBManager db) {
		this.sc = sc;
		this.db = db;
	}

	public void writePost(Member m) throws Exception {
		/* 게시글 등록 */
		Board b = new Board();
		System.out.println("게시글 작성을 시작합니다...");
		System.out.print("게시글의 제목을 입력하시오 >> ");
		b.setTitle(sc.next());
		sc.nextLine(); // 버퍼 제거
		System.out.print("게시글의 내용을 입력하시오 >> ");
		b.setContent(sc.nextLine());

		String query = "INSERT INTO tbl_board VALUES (" + (++bno) + ",'" + b.getTitle() + "','" + b.getContent()
				+ "', SYSDATE, '" + session.getUserid() + "')";
		db.getStatement().executeUpdate(query);
	}

	public void viewAll() throws Exception {
		/* 전체 게시글 조회 */
		System.out.println("전체 게시글 조회를 시작합니다...");
		System.out.println("==============");
		List<Board> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_board";
		ResultSet rs = db.getStatement().executeQuery(query);

		while (rs.next()) {
			Board b = new Board();
			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setContent(rs.getString("content"));
			b.setRegdate(rs.getString("regdate"));
			b.setWriter(rs.getString("writer"));
			list.add(b);
		}

		for (Board board : list) {
			System.out.println(board);
		}
	}

	public void viewByNumber() throws Exception {
		/* 특정 게시글 번호 조회 */
		System.out.print("조회를 원하는 게시글의 번호를 입력하시오 >> ");
		int input = sc.nextInt();
		System.out.println("==============");
		String query = "SELECT * FROM tbl_board WHERE bno = " + input;
		ResultSet rs = db.getStatement().executeQuery(query);

		if (rs.next()) {
			Board b = new Board();
			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setContent(rs.getString("content"));
			b.setRegdate(rs.getString("regdate"));
			b.setWriter(rs.getString("writer"));
			System.out.println(b);
		} else {
			System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
		}
	}
}
