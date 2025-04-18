package chapter05;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import chapter05_vo.DBcon;
import chapter05_vo.Employee;

public class EmployeeService {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;
	public static String dept;

	public EmployeeService(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

	/* 영업사원정보생성 */
	public void employeeInfo() throws ClassNotFoundException, SQLException {
		Employee e = new Employee();

		System.out.print("사원번호를 입력하세요 >> ");
		e.setE_no(sc.nextInt());
		sc.nextLine();
		System.out.println("사원비밀번호를 입력하세요 >> ");
		e.setE_pw(sc.nextLine());
		System.out.print("사원이름을 입력하세요 >> ");
		e.setE_name(sc.nextLine());
		System.out.print("사원직급을 입력하세요 >> ");
		e.setE_pos(sc.nextLine());
		System.out.println("사원부서를 입력하세요 >> ");
		e.setE_dept(sc.nextLine());
		System.out.print("입사일자를 입력하세요 >> ");
		e.setE_date(sc.nextLine());

		String query = "INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setInt(1, e.getE_no());
		pstmt.setString(2, e.getE_pw());
		pstmt.setString(3, e.getE_name());
		pstmt.setString(4, e.getE_pos());
		pstmt.setString(5, e.getE_dept());
		pstmt.setString(6, e.getE_date());

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("영업사원 정보가 정상적으로 저장되었습니다 ! ");
			System.out.println("입력된 내용 -> " + e.toString());
		}
	}

	/* 영업사원정보수정 */
	public void updateEmployeeInfo() throws ClassNotFoundException, SQLException {
		Employee e = new Employee();
		int ivalue = 0;
		String svalue = null;

		System.out.println("영업사원정보 수정을 시작합니다...");
		System.out.print("변경을 원하는 사원번호를 입력하세요 >> ");
		e.setE_no(sc.nextInt());
		int code = e.getE_no();

		System.out.print("""
				1.사원번호 2.사원비밀번호 3.사원이름 4.사원직급 5.사원부서 6.입사일자
				수정할 항목을 선택해주세요 >>
				""");
		int choice = sc.nextInt();

		String items = switch (choice) {
		case 1 -> "e_no";
		case 2 -> "e_pw";
		case 3 -> "e_name";
		case 4 -> "e_pos";
		case 5 -> "e_dept";
		case 6 -> "e_date";
		default -> null;
		};

		if (choice == 1) {
			System.out.print("수정할 내용을 입력하세요 >> ");
			ivalue = sc.nextInt();
		} else {
			System.out.print("수정할 내용을 입력하세요 >> ");
			svalue = sc.next();
		}

		String query = "UPDATE employee SET " + items + " = ? WHERE e_no = ?";
		pstmt = db.connect().prepareStatement(query);

		if (choice == 1) {
			pstmt.setInt(1, ivalue);
		} else {
			pstmt.setString(1, svalue);
		}
		pstmt.setInt(2, code);

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("영업사원정보가 갱신되었습니다...");
		}
	}

	/* 사원계정로그인 */
	public void login() throws ClassNotFoundException, SQLException {
		Employee e = new Employee();
		
		System.out.print("사원번호를 입력하세요 >> ");
		int id = sc.nextInt(); sc.nextLine();
		System.out.print("사원비밀번호를 입력하세요 >> ");
		String pw = sc.nextLine();
		
		String query = "SELECT e_dept FROM employee WHERE e_no = ? AND e_pw = ?";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setInt(1, id);
		pstmt.setString(2, pw);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			e.setE_dept(rs.getString("e_dept"));
			dept = e.getE_dept();
		}
		
		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("\n" + dept + " 부서 " +  id + "님 오늘도 좋은 하루 보내세요.\n");
			
			SessionStorge session = new SessionStorge();
			session.loginid(id);
		}
		else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
		}
	}
	
}
