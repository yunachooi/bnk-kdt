package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.JoinVO;

public class MoneyDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<JoinVO> selectAll() throws ClassNotFoundException, SQLException {
		List<JoinVO> list = new ArrayList<>();

		String query = "SELECT mem.custno AS custno, mem.custname AS custname, "
				+ "DECODE(grade, 'A', 'VIP', DECODE(grade, 'B', '일반', '직원')) AS grade, SUM(mon.price) AS price "
				+ "FROM member_tbl_02 mem, money_tbl_02 mon WHERE mem.custno = mon.custno GROUP BY mem.custno, mem.custname, mem.grade "
				+ "ORDER BY price DESC";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			JoinVO j = new JoinVO();
			
			j.setCustno(rs.getInt("custno"));
			j.setCustname(rs.getString("custname"));
			j.setGrade(rs.getString("grade"));
			j.setPrice(rs.getInt("price"));

			list.add(j);
		}
		return list;
	}
}
