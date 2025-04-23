package chapter03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chapter03.vo.MemberVO;

public class MemberDao {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void insert(String id, String pw, String name, String grade) throws ClassNotFoundException, SQLException {
		String query = "INSERT INTO t_member VALUES (?, ?, ?, ?)";
		pstmt = conn.prepareStatement(query);

		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.setString(4, grade);

		pstmt.executeUpdate();
	}

	public List<MemberVO> selectAll() throws ClassNotFoundException, SQLException {
		List<MemberVO> list = new ArrayList<>();

		String query = "SELECT * FROM t_member";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			MemberVO m = new MemberVO();

			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setGrade(rs.getString("grade"));

			list.add(m);
		}

		return list;
	}
}
