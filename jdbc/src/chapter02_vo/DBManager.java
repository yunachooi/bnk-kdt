package chapter02_vo;

import java.sql.*;

public class DBManager {
    private Connection conn;
    private Statement stmt;

    public void connect() throws ClassNotFoundException, SQLException {
    	/*connection*/
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:testdb";
        String user = "green";
        String password = "1234";
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
    }

    public Statement getStatement() {
        return stmt;
    }

    public Connection getConnection() {
        return conn;
    }
}
