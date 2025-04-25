package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.ProductCodeVO;

public class ProductCodeDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<ProductCodeVO> selectAll() throws ClassNotFoundException, SQLException {
		List<ProductCodeVO> list = new ArrayList<>();

		String query = "SELECT pcode, pname, cost, TO_CHAR((cost * 0.9), '999,999') AS dis10, TO_CHAR((cost * 0.85), '999,999') AS dis15 FROM tbl_product_202101 ORDER BY pcode";
		
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			ProductCodeVO p = new ProductCodeVO();
			
			p.setPcode(rs.getString("pcode"));
			p.setPname(rs.getString("pname"));
			p.setCost(rs.getString("cost"));
			p.setDis10(rs.getString("dis10"));
			p.setDis15(rs.getString("dis15"));
			
			list.add(p);
		}
		return list;
	}
}
