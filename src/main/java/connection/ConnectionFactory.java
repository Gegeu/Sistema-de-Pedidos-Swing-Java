/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Junior
 */
public class ConnectionFactory {
    public static Connection getConnection() {
        
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/trabalhofinalpedidos", "root", "banco123");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}

