package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBtest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBcon db = new DBcon();
		try {
			String query = "SELECT * FROM t1";
			
			PreparedStatement pstmt = db.connect().prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int c1 = rs.getInt("c1");
				String c2 = rs.getString("c2");
				
				System.out.println(c1 + ", " + c2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
