package chapter01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest_Update {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:testdb";
		String uid = "green";
		String upw = "1234";

		Connection conn = DriverManager.getConnection(url, uid, upw);
		Statement stmt = conn.createStatement();

		String query = "UPDATE tbl_member SET name = '임꺽정' WHERE id = 'id5'";
		int result = stmt.executeUpdate(query);
		
		System.out.println("result : " + result);
	}

}
