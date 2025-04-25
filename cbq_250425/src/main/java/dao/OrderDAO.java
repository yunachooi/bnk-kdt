package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.OrderVO;

public class OrderDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void orderRegist(OrderVO o) throws SQLException {
		String query = "INSERT INTO tbl_order_202101 VALUES(?, ?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(query);
	
		pstmt.setString(1, o.getOrderno());
		pstmt.setString(2, o.getShopno());
		pstmt.setString(3, o.getOrderdate());
		pstmt.setString(4, o.getPcode());
		pstmt.setInt(5, o.getAmount());
			
		pstmt.executeUpdate();
	}
}
