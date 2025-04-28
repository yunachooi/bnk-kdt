package chapter07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chapter07.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO memberDao = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getMemberDao() {
		return memberDao;
	}
	
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list = new ArrayList<>();
		
		Connection conn = DButil.getConnection();
		String query = "SELECT * FROM tbl_member";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String grade = rs.getString("grade");
				
				MemberDTO m = new MemberDTO(id, pw, name, phone, grade);
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void insert(MemberDTO m){
		Connection conn = DButil.getConnection();
		
		String query = "INSERT INTO tbl_member VALUES(?, ?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(query);) {
			/*자원 사용이 끝나면 자동으로 반납*/
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getGrade());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(){
		Connection conn = DButil.getConnection();
		
		String query = "UPDATE tbl_member SET grade = ? WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(){
		Connection conn = DButil.getConnection();
		
		String query = "DELETE FROM tbl_member WHERE id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
