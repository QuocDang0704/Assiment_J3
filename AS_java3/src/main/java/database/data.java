/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Đặng Quốc
 */
public class data {

    private final static String usernam = "sa";
    private final static String passWord = "123";

    public static Connection opeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost;database=FPL_DAO_TAO;";
        Connection con = DriverManager.getConnection(connectionUrl, usernam, passWord);
        return con;
    }
}
