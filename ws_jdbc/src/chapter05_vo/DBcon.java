package chapter05_vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Data;

@Data
public class DBcon {
    public Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:testdb";
        String user = "green";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }
}
