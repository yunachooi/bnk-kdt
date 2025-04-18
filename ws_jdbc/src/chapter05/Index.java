package chapter05;

import java.sql.SQLException;
import java.util.Scanner;

import chapter05_vo.DBcon;

public class Index {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		DBcon jdbc = new DBcon();
		jdbc.connect();

		CustomerService customer = new CustomerService(sc, jdbc);
		ProductService product = new ProductService(sc, jdbc);
		StockService stock = new StockService(sc, jdbc);
		EmployeeService employee = new EmployeeService(sc, jdbc);

		System.out.println("""
				'A'전자 자재 관리 프로그램입니다.
				로그인을 진행해주세요...
				""");

		employee.login();
		if (EmployeeService.dept.equals("영업")) {
			System.out.println("""
					1.상품거래 2.전체상품재고조회 3.특정상품재고조회 4.상품입고 5.상품출고
					원하는 번호를 입력하세요 >>
					""");

			int menu = sc.nextInt();

			switch (menu) {
			case 2 -> stock.getStock();
			case 3 -> stock.getProductStock();
			default -> System.out.println("잘못된 입력입니다...");
			}
		} else {
			System.out.println("""
					1.영업사원조회 2.판매실적조회
					원하는 번호를 입력하세요 >>
					""");

			int menu = sc.nextInt();

			switch (menu) {
			
			default -> System.out.println("잘못된 입력입니다...");
			}
		}

	}

}
