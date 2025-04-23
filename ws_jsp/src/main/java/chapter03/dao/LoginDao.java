package chapter03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chapter03.vo.MemberVO;

public class LoginDao {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	boolean flag = false;
	
	public boolean checkUser(String id, String pw) throws SQLException {
		String query = "SELECT * FROM t_member WHERE id=? AND pw=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		rs = pstmt.executeQuery();

		while (rs.next()) {
			MemberVO m = new MemberVO();

			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			flag = true;
		}
		
		return flag;
	}
	
	public String checkName(String id) throws SQLException {
		String name = null;
		
		String query = "SELECT name FROM t_member WHERE id=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			MemberVO m = new MemberVO();
			m.setName(rs.getString("name"));
			name = m.getName();
		}
		return name;
	}
}
