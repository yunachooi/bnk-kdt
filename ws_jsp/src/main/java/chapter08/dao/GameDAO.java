package chapter08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chapter03.dao.DBcon;
import chapter08.dto.RspDTO;
import jakarta.servlet.http.HttpSession;

public class GameDAO {
    private Connection conn = DBcon.connect();
    private PreparedStatement pstmt;
    private ResultSet rs;

    private HttpSession session;

    public GameDAO(HttpSession session) {
        this.session = session;
    }

    private String getUserId() {
        return (String) session.getAttribute("userId");
    }

    public void update(int win, int lose, int draw) {
        String query = "UPDATE tbl_rsp SET win = ?, lose = ?, draw = ? WHERE id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, win);
            pstmt.setInt(2, lose);
            pstmt.setInt(3, draw);
            pstmt.setString(4, getUserId());

            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public RspDTO select(String userId) {
        RspDTO rsp = null;
        String query = "SELECT win, lose, draw FROM tbl_rsp WHERE id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                rsp = new RspDTO();
                rsp.setWin(rs.getInt("win"));
                rsp.setLose(rs.getInt("lose"));
                rsp.setDraw(rs.getInt("draw"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rsp;
    }
}
