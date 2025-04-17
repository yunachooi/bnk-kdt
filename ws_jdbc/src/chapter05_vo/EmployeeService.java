package chapter05_vo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeService {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

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
		System.out.print("사원이름을 입력하세요 >> ");
		e.setE_name(sc.nextLine());
		System.out.print("사원직급을 입력하세요 >> ");
		e.setE_rank(sc.nextLine());
		System.out.print("입사일자를 입력하세요 >> ");
		e.setE_date(sc.nextLine());

		String query = "INSERT INTO employee VALUES (?, ?, ?, ?)";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setInt(1, e.getE_no());
		pstmt.setString(2, e.getE_name());
		pstmt.setString(3, e.getE_rank());
		pstmt.setString(4, e.getE_date());

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
				1.사원번호 2.사원이름 3.사원직급 4.입사일자
				수정할 항목을 선택해주세요 >>
				""");
		int choice = sc.nextInt();

		String items = switch (choice) {
		case 1 -> "e_no";
		case 2 -> "e_name";
		case 3 -> "e_rank";
		case 4 -> "e_date";
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

}
