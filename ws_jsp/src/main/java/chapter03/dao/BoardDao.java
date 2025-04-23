package chapter03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chapter03.vo.BoardVO;

public class BoardDao {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;

	public List<BoardVO> selectAll() throws ClassNotFoundException, SQLException {
		List<BoardVO> list = new ArrayList<>();

		String query = "SELECT * FROM tbl_board";
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			BoardVO b = new BoardVO();

			b.setBno(rs.getInt("bno"));
			b.setTitle(rs.getString("title"));
			b.setContent(rs.getString("content"));
			b.setWriter(rs.getString("writer"));
			b.setDate(rs.getString("date"));

			list.add(b);
		}
		return list;
	}

}
