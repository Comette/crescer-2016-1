package br.com.crescer.aula03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtils {
    // Oracle Thin 
    // jdbc:oracle:thin:@<HOST>:<PORT>:<SID>
    // oracle.jdbc.driver.OracleDriver

    static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String user = "CRESCER16";
    static final String pass = "CRESCER16";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);        
    }
}
