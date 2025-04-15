package chapter04_vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Data;

@Data
public class DBcon {
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
}
