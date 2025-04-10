package chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";
		
		Connection conn = DriverManager.getConnection(url, uid, upw);
		Statement stmt = conn.createStatement();
		
		String query = "INSERT INTO tbl_member VALUES ('id5', '1234', '홍길수', '010-9876-9876', 'B')";
		int result = stmt.executeUpdate(query);
		
		System.out.println("result : " + result);
	}

}
