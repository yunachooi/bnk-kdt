package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrderListVO;

public class OrderListDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<OrderListVO> selectAll() throws ClassNotFoundException, SQLException {
		List<OrderListVO> list = new ArrayList<>();

		String query = "SELECT s.shopno, s.shopname, SUBSTR(o.orderno, 1, 4) || '-' || SUBSTR(o.orderno, 5, 4) AS orderno, "
				+ "SUBSTR(o.orderdate, 1, 4) || '-' || SUBSTR(o.orderdate, 5, 2) || '-' || SUBSTR(o.orderdate, 7, 2) AS orderdate, "
				+ "p.pcode, p.pname, o.amount, TO_CHAR(p.cost, '9,999') AS cost, TO_CHAR((o.amount * p.cost), '999,999') AS cprice, "
				+ "TO_CHAR((o.amount * p.cost) - (o.amount * p.cost / s.discount), '999,999') AS dprice "
				+ "FROM tbl_product_202101 p, tbl_shop_202101 s, tbl_order_202101 o "
				+ "WHERE s.shopno = o.shopno AND p.pcode = o.pcode ORDER BY o.orderno";
		
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			OrderListVO o = new OrderListVO();
			
			o.setShopno(rs.getString("shopno"));
			o.setShopname(rs.getString("shopname"));
			o.setOrderno(rs.getString("orderno"));
			o.setOrderdate(rs.getString("orderdate"));
			o.setPcode(rs.getString("pcode"));
			o.setPname(rs.getString("pname"));
			o.setAmount(rs.getInt("amount"));
			o.setCost(rs.getString("cost"));
			o.setCprice(rs.getString("cprice"));
			o.setDprice(rs.getString("dprice"));
			
			list.add(o);
		}
		return list;
	}
}
