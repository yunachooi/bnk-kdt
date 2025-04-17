package chapter05_vo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

	public CustomerService(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

	public void customerInfo() throws ClassNotFoundException, SQLException {
		Customer c = new Customer();
		System.out.print("거래처코드를 입력해주세요>> ");
		c.setC_code(sc.nextLine());
		System.out.print("거래처명을 입력해주세요>> ");
		c.setC_name(sc.nextLine());
		System.out.print("거래처경영자명을 입력해주세요>> ");
		c.setC_ceo(sc.nextLine());
		System.out.print("거래처주소를 입력해주세요>> ");
		c.setC_addre(sc.nextLine());
		System.out.print("거래처연락처를 입력해주세요>> ");
		c.setC_phone(sc.nextLine());
		System.out.println("입력된 내용 -> " + c.toString());

		db.connect();
		String query = "INSERT INTO customer VALUES(?,?,?,?,?)";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setString(1, c.getC_code());
		pstmt.setString(2, c.getC_name());
		pstmt.setString(3, c.getC_ceo());
		pstmt.setString(4, c.getC_addre());
		pstmt.setString(5, c.getC_phone());

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("거래처 정보가 정상적으로 저장되었습니다 !");
			System.out.println("입력된 내용 -> " + c.toString());
		}

	}

	public void customerUpdateInfo() throws ClassNotFoundException, SQLException {
		Customer c = new Customer();
		String svalue = null;

		System.out.println("거래처 정보 수정을 시작합니다...");
		System.out.print("변경을 원하는 거래처 코드를 입력하세요 >> ");
		c.setC_code(sc.nextLine());
		String code = c.getC_code();

		System.out.print("""
				1.거래처코드 2.거래처명 3.경영자명 4.거래처주소 5.거래처연락처
				수정할 항목을 선택해주세요 >>
				""");
		int choice = sc.nextInt();

		String items = switch (choice) {
		case 1 -> "c_code";
		case 2 -> "c_name";
		case 3 -> "c_ceo";
		case 4 -> "c_addr";
		case 5 -> "c_phone";
		default -> null;
		};

		System.out.print("수정할 내용을 입력하세요 >> ");
		svalue = sc.next();

		String query = "UPDATE customer SET " + items + " = ? WHERE c_code = ?";
		pstmt = db.connect().prepareStatement(query);

		pstmt.setString(1, svalue);
		pstmt.setString(2, code);

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("거래처 정보가 갱신되었습니다...");
		}
	}

}
