package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;

public class MemberDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void insert(MemberVO m) throws SQLException {
		String query = "INSERT INTO member_tbl_02 VALUES(?, ?, ?, ?, ?, ?, ?)";
				
			pstmt = conn.prepareStatement(query);
		
			pstmt.setInt(1, m.getCustno());
			pstmt.setString(2, m.getCustname());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getJoindate());
			pstmt.setString(6, m.getGrade());
			pstmt.setString(7, m.getCity());
				
			pstmt.executeUpdate();
	}
	
	public List<MemberVO> selectAll() throws ClassNotFoundException, SQLException {
		List<MemberVO> list = new ArrayList<>();

		String query = "SELECT custno, custname, phone, address, TO_CHAR(joindate, 'RRRR-MM-DD') AS joindate,"
				+ "DECODE(grade, 'A', 'VIP', DECODE(grade, 'B', '일반', '직원')) AS grade, city FROM member_tbl_02";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			MemberVO m = new MemberVO();
			
			m.setCustno(rs.getInt("custno"));
			m.setCustname(rs.getString("custname"));
			m.setPhone(rs.getString("phone"));
			m.setAddress(rs.getString("address"));
			m.setJoindate(rs.getString("joindate"));
			m.setGrade(rs.getString("grade"));
			m.setCity(rs.getString("city"));

			list.add(m);
		}
		return list;
	}

	public List<MemberVO> detailSelect(int id) throws SQLException {
		List<MemberVO> list = new ArrayList<>();

		String query = "SELECT custno, custname, phone, address, TO_CHAR(joindate, 'RRRR-MM-DD') AS joindate, grade, city FROM member_tbl_02 WHERE custno = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, id);
		
		rs = pstmt.executeQuery();

		while (rs.next()) {
			MemberVO m = new MemberVO();
			
			m.setCustno(rs.getInt("custno"));
			m.setCustname(rs.getString("custname"));
			m.setPhone(rs.getString("phone"));
			m.setAddress(rs.getString("address"));
			m.setJoindate(rs.getString("joindate"));
			m.setGrade(rs.getString("grade"));
			m.setCity(rs.getString("city"));

			list.add(m);
		}
		return list;
	}
	
	public void update(MemberVO m, int id) throws SQLException {
		String query = "UPDATE member_tbl_02 SET custno = ?, custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ? WHERE custno = ?";
		pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1, m.getCustno());
		pstmt.setString(2, m.getCustname());
		pstmt.setString(3, m.getPhone());
		pstmt.setString(4, m.getAddress());
		pstmt.setString(5, m.getJoindate());
		pstmt.setString(6, m.getGrade());
		pstmt.setString(7, m.getCity());
		pstmt.setInt(8, id);
		
		pstmt.executeUpdate();
	}
	
}
