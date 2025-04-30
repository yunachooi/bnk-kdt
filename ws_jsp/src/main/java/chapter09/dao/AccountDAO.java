package chapter09.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:testdb",
					"green",
					"1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	public void transfer(String fromAccountId, String toAccountId, double amount) throws SQLException {
		Connection conn = null;
		PreparedStatement withdrawStmt = null;
		PreparedStatement depositStmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false); // 트랜잭션 시작
			
			//출금 계좌에서 금액 차감
			String withdrawSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
			withdrawStmt = conn.prepareStatement(withdrawSql);
			withdrawStmt.setDouble(1, amount);
			withdrawStmt.setString(2, fromAccountId);
			withdrawStmt.setDouble(3, amount);
			int withdrawResult = withdrawStmt.executeUpdate();
			
			if(withdrawResult == 0) {
				throw new SQLException("잔액 부족 또는 결과 없음");
			}
			
			String depositSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
			depositStmt = conn.prepareStatement(depositSql);
			depositStmt.setDouble(1, amount);
			depositStmt.setString(2, toAccountId);
			int depositResult = depositStmt.executeUpdate();
			
			if(depositResult == 0) {
				throw new SQLException("입금 계좌 없음");
			}
			
			conn.commit(); // 트랜잭션 커밋
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback(); // 오류 발생 시 롤백
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			throw e;
		} finally {
			//리소스 해제
			if(withdrawStmt != null) withdrawStmt.close();
			if(depositStmt != null) depositStmt.close();
			if(conn != null) {
				conn.setAutoCommit(true); //원래 상태로 복구
				conn.close();
			}
		}
		
	}


}