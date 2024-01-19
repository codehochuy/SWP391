/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBContext {
    private Connection conn = null;

    public DBContext() {
        try{
            String usr = "sa";
            String pass="12345";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=HouseSystem";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,usr,pass);
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public void close() throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
}
