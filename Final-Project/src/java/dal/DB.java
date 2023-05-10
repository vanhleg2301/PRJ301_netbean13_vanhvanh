/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author DELL
 */
public class DB {
    public static Connection makeConnection()
            throws ClassNotFoundException, SQLException {
//        // 1. load driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        // 2. create connection String 
//        String url = "jdbc:sqlserver:"
//                + "//DESKTOP-JPL3VRQ\\SQLEXPRESS:1433"
//                + ";databaseName=Store";
//        // 3. Connection 
//        Connection con = DriverManager.getConnection(url, "sa", "12345");
//        return con;
        //@Resource(name="Dbcon")
        //private DataSource dataSource;
        Connection con = null;
        try {
            Context ctx = new InitialContext();
            Context envCtx = (Context) ctx.lookup("java:comp/env");
            DataSource dataSource = (DataSource) envCtx.lookup("Dbcon");
            con = dataSource.getConnection();
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        return con;
    }   
}
