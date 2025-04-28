package chapter07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButilTest {

	public static void main(String[] args) throws SQLException {
		DButil db = new DButil();
		
		Connection conn = db.getConnection();
		
		String query = "SELECT * FROM tbl_member";
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs);
		}

		db.close(conn, pstmt, rs);
	}

}
