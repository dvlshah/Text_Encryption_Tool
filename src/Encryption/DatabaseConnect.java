/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;
import java.sql.*;

public class DatabaseConnect {
    
    public Connection cn = null;
    public Statement st = null;
    public ResultSet rs = null;
    public ResultSetMetaData rsmd;
    
    public DatabaseConnect(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
        }
        catch(Exception e){
            System.out.println("Error in connection"+e);
        }
    }
}