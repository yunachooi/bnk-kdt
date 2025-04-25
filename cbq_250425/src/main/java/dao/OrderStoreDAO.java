package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrderStoreVO;

public class OrderStoreDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<OrderStoreVO> selectAll() throws ClassNotFoundException, SQLException {
		List<OrderStoreVO> list = new ArrayList<>();

		String query = "SELECT o.shopno, p.pcode, p.pname, SUM(o.amount) AS amount "
				+ "FROM tbl_product_202101 p, tbl_order_202101 o WHERE p.pcode = o.pcode GROUP BY o.shopno, p.pcode, p.pname ORDER BY shopno";
		
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			OrderStoreVO o = new OrderStoreVO();
			
			o.setShopno(rs.getString("shopno"));
			o.setPcode(rs.getString("pcode"));
			o.setPname(rs.getString("pname"));
			o.setAmount(rs.getString("amount"));
			
			list.add(o);
		}
		return list;
	}
}
