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
			b.setRegdate(rs.getString("regdate"));

			list.add(b);
		}
		return list;
	}

	public void insert(BoardVO b) throws SQLException {
		String query = "INSERT INTO tbl_board VALUES(seq_board.NEXTVAL, ?, ?, ?, SYSDATE)";
		
		pstmt = conn.prepareStatement(query);

		pstmt.setString(1, b.getTitle());
		pstmt.setString(2, b.getContent());
		pstmt.setString(3, b.getWriter());

		pstmt.executeUpdate();
	}

}
