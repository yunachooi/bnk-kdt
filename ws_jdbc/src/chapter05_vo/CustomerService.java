package chapter05_vo;

import java.sql.PreparedStatement;
import java.util.Scanner;

import chapter04_vo.DBcon;

public class CustomerService {
	private final Scanner sc;
	private final DBcon db;
	PreparedStatement pstmt;

	public CustomerService(Scanner sc, DBcon db) {
		this.sc = sc;
		this.db = db;
	}

}
