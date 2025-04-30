package chapter08.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcon {
	/* 1. 접속 객체(Connection) 제공 */
	public static Connection getConnection() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";

		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			if (conn != null) {
				System.out.println("DB 접속 성공...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/* 2. DAO에서 사용된 자원 해제 (Connection, Statement, ResultSet) */
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				close(conn, pstmt);
				System.out.println("추가로 rs 자원해제");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("conn 자원해제");
			}
			if (pstmt != null) {
				pstmt.close();
				System.out.println("pstmt 자원해제");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
