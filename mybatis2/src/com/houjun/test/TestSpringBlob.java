package com.houjun.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestSpringBlob {


    //    static String url = "jdbc:postgresql://127.0.0.1:5432/myUop";
    static String url = ResourceBundle.getBundle("jdbc").getString("url");

    static String usr = ResourceBundle.getBundle("jdbc").getString("username");

    static String psd = ResourceBundle.getBundle("jdbc").getString("password");


    public static void main(String args[]) {

        Connection conn = null;

        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url, usr, psd);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {

                System.out.print(rs.getString(1));

                System.out.print("  ");

                System.out.println(rs.getString(2));

            }

            rs.close();

            st.close();

            conn.close();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}