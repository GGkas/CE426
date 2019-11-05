/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce426;

import java.sql.*;

/**
 *
 * @author gkoffas
 */
public class ConnectionProvider {
    static Connection con = null;
    static private final String CONNURL = "jdbc:mysql:@localhost:3306:webapp";
    static private final String USERNAME = "root";
    static private final String PASSWORD = "vento_aureo";
    
    public ConnectionProvider() {
        
    }
    
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(CONNURL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        
        return con;
    }
}
