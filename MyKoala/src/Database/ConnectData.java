/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyen van cuong
 */
public class ConnectData {
    private Connection conn;
    private String user = "root";
    private String url = "jdbc:mysql://localhost/projectkoala";
    private String password = "akatsuki";
    
    public Connection connectionDatabase() {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url + "?user=" + user + "&password=" + password);
            Statement statement = conn.createStatement();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ConnectData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
