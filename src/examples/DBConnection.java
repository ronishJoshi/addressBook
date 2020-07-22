package examples;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SONY
 */
public class DBConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book?zeroDateTimeBehavior=convertToNull", "root", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}