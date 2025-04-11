package chapter02_vo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import chapter02.SessionStorge;

public class MemberService {
	private final Scanner sc;
	private final DBManager db;
	private Member member;
	private SessionStorge session;

	public MemberService(Scanner sc, DBManager db) {
		this.sc = sc;
		this.db = db;
	}

	public void register() throws Exception {
		/* 신규회원가입 진행 */
		member = new Member();
		System.out.println("회원가입을 시작합니다...");
		boolean flag = true;
		while (flag) {
			System.out.print("아이디를 입력해주세요 >> ");
			member.setId(sc.next());
			System.out.println("==============");

			if (idCheck(member.getId()) == false) {
				/* DB에 없을 경우 */
				System.out.println("사용 가능한 아이디입니다.");
				System.out.println("==============");
				flag = false;
			} else { /* DB에 있을 경우 */
				System.out.println("이미 사용 중인 아이디입니다.");
				System.out.println("다른 아이디를 입력해주세요.");
				System.out.println("==============");
			}
		}
		System.out.print("비밀번호를 입력해주세요 >> ");
		member.setPw(sc.next());
		System.out.print("이름을 입력해주세요 >> ");
		member.setName(sc.next());
		System.out.print("전화번호를 입력해주세요 >> ");
		member.setPhone(sc.next());

		String query = "INSERT INTO tbl_member VALUES ('" + member.getId() + "','" + member.getPw() + "','"
				+ member.getName() + "','" + member.getPhone() + "','" + member.getGrade() + "')";
		db.getStatement().executeUpdate(query);

		System.out.println("회원가입이 정상적으로 완료되었습니다.");
	}

	public void login() throws Exception {
		/* 특정 게시글 번호 조회 */
		System.out.print("아이디를 입력하세요. >> ");
		String id = sc.next();
		System.out.print("비밀번호를 입력하세요. >> ");
		String pw = sc.next();
		String query = "SELECT * FROM tbl_member WHERE id = '" + id + "' AND pw = '" + pw + "'";
		ResultSet rs = db.getStatement().executeQuery(query);

		if (rs.next()) {
			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setPhone(rs.getString("phone"));
			m.setGrade(rs.getString("grade"));
			System.out.println("==============");
			System.out.println(m.getId() + "님 로그인되었습니다.");

			/* 로그인 정보 저장 */
			session = new SessionStorge();
			session.loginid(m.getId());
		} else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			System.out.println("==============");
		}
	}

	public boolean idCheck(String getid) throws SQLException {
		String query = "SELECT * FROM tbl_member WHERE id = '" + getid + "'";
		ResultSet rs = db.getStatement().executeQuery(query);

		if (rs.next()) {
			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setPhone(rs.getString("phone"));
			m.setGrade(rs.getString("grade"));
			return true;
		} else {
			return false;
		}
	}

	public Member getMember() {
		return member;
	}
}