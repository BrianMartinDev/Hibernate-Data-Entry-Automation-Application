package com.tableEntry;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author Brian Martin
 */
public class Main {

    public static void main(String[] args) {

        // Connection fields for access to database
        String jdbcUrl = "jdbc:mysql://localhost:3306/harry_potter_wand_application?useSSL=false";
        String user = "root";
        String pass = "admin123";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("connect succcess!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
