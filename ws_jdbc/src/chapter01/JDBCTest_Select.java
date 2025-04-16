package chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest_Select {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		List<Member> list = new ArrayList<>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//		}
//		catch(ClassNotFoundException e) {
//			e.printStackTrace();
//			System.err.println("\n마리아DB가 설치되지 않았습니다...");
//		}
		

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String user = "green";
		String password = "1234";

		/* 연결 : 쿼리 작성 및 쿼리 실행, 조회 일 경우에는 쿼리 결과까지 받음. */

		// 접속담당 - Connection
		Connection conn = DriverManager.getConnection(url, user, password);

		// 쿼리실행 - Statement *반드시 sql.Statement를 import.
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM tbl_member"; // 실행할 쿼리는 문자열로 생성

		// 쿼리결과 - ResultSet
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) { // next 값이 있으면 true, 값이 없으면 false
			Member member = new Member();

			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String grade_temp = rs.getString("grade");
			char grade = grade_temp.charAt(0);

			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setPhone(phone);
			member.setGrade(grade);

			list.add(member);
		}

		for (Member m : list) {
			System.out.println(m);
		}

//		System.out.println("---------------------");
//
//		rs.next(); // rs 참조변수의 첫번째 위치는 데이터의 위치가 아님.
//		Member member = new Member();
//		String id = rs.getString("id");
//		String pw = rs.getString("pw");
//		String name = rs.getString("name");
//		String phone = rs.getString("phone");
//		String grade_temp = rs.getString("grade");
//		char grade = grade_temp.charAt(0);
//
//		member.setId(id);
//		member.setPw(pw);
//		member.setName(name);
//		member.setPhone(phone);
//		member.setGrade(grade);
//
//		list.add(member);
//
//		for (Member m : list) {
//			System.out.println(m);
//		}
	}

}
