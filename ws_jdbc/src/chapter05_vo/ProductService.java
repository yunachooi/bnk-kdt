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
		p.setP_cost(sc.nextInt()); sc.nextLine();
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
			System.out.println("상품 정보 입력이 정상적으로 처리되었습니다 ! ");
			System.out.println("입력된 내용 -> " + p.toString());
		}
	}
}
