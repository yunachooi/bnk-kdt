package chapter08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chapter03.dao.DBcon;
import chapter07.dto.MemberDTO;
import chapter08.dto.RspDTO;

public class RspDAO {
	private Connection conn = DBcon.connect();
	private PreparedStatement pstmt;
	private ResultSet rs;
	boolean flag = false;

	public List<RspDTO> select() throws SQLException {
		List<RspDTO> list = new ArrayList<>();
		
		String query = "SELECT * FROM tbl_rsp";
		pstmt = conn.prepareStatement(query);
		
		rs = pstmt.executeQuery();

		while (rs.next()) {
			RspDTO r = new RspDTO();

			r.setId(rs.getString("id"));
			r.setPw(rs.getString("pw"));
			r.setWin(rs.getInt("win"));
			r.setLose(rs.getInt("lose"));
			r.setDraw(rs.getInt("draw"));
			
			list.add(r);
		}
		
		return list;
	}
	
	public void insert(String id, String pw) throws SQLException {
		String query = "INSERT INTO tbl_rsp VALUES(?, ?, 0, 0, 0)";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		
		pstmt.executeQuery();
	}
}
