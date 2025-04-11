package chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest_Insert2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = DriverManager.getConnection(url, uid, upw);
		String test_id = "test";
		String test_pw = "1234";
		String test_name = "test";
		String test_phone = "010-0000-0000";
		String test_grade = "A";
		
		String query = "INSERT INTO tbl_member VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, test_id);
		pstmt.setString(2, test_pw);
		pstmt.setString(3, test_name);
		pstmt.setString(4, test_phone);
		pstmt.setString(5, test_grade);
		
		int result = pstmt.executeUpdate();
		
		System.out.println("result : " + result);
	}

}
