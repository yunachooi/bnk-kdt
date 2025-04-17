package chapter05_vo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

	public ProductService(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

	/* 상품정보생성 */
	public void productInfo() throws SQLException, ClassNotFoundException {
		Product p = new Product();

		System.out.print("상품코드를 입력하세요 >> ");
		p.setP_code(sc.nextLine());
		System.out.print("상품명을 입력하세요 >> ");
		p.setP_name(sc.nextLine());
		System.out.print("상품단가를 입력하세요 >> ");
		p.setP_cost(sc.nextInt());
		sc.nextLine();
		System.out.print("상품 소문류를 입력하세요 >> ");
		p.setP_group(sc.nextLine());

		String query = "INSERT INTO product VALUES (?, ?, ?, ?)";
		pstmt = db.connect().prepareStatement(query);
		pstmt.setString(1, p.getP_code());
		pstmt.setString(2, p.getP_name());
		pstmt.setInt(3, p.getP_cost());
		pstmt.setString(4, p.getP_group());

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("상품 정보가 정상적으로 저장되었습니다 ! ");
			System.out.println("입력된 내용 -> " + p.toString());
		}
	}

	/* 상품정보수정 */
	public void updateProductInfo() throws ClassNotFoundException, SQLException {
		Product p = new Product();
		int ivalue = 0;
		String svalue = null;

		System.out.println("상품정보 수정을 시작합니다...");
		System.out.print("변경을 원하는 상품코드를 입력하세요 >> ");
		p.setP_code(sc.nextLine());
		String code = p.getP_code();

		System.out.print("""
				1.상품코드 2.상품명 3.상품단가 4.소분류
				수정할 항목을 선택해주세요 >>
				""");
		int choice = sc.nextInt();

		String items = switch (choice) {
		case 1 -> "p_code";
		case 2 -> "p_name";
		case 3 -> "p_cost";
		case 4 -> "p_group";
		default -> null;
		};

		if (choice == 3) {
			System.out.print("수정할 내용을 입력하세요 >> ");
			ivalue = sc.nextInt();
		} else {
			System.out.print("수정할 내용을 입력하세요 >> ");
			svalue = sc.next();
		}

		String query = "UPDATE product SET " + items + " = ? WHERE p_code = ?";
		pstmt = db.connect().prepareStatement(query);

		if (choice == 3) {
			pstmt.setInt(1, ivalue);
		} else {
			pstmt.setString(1, svalue);
		}
		pstmt.setString(2, code);

		int result = pstmt.executeUpdate();
		if (result == 1) {
			System.out.println("상품코드정보가 갱신되었습니다...");
		}
	}

}
