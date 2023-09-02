package com.example.prac.chapter05;

import java.sql.*;

public class JDBCTester {
    private static final String URL = "jdbc:sqlite:/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/jdbctest.db";
    private static final String USR = "admin";
    private static final String PWD = "admin";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USR, PWD);
            Statement stmt = conn.createStatement();

            String sql = String.format("select name, city from Publishers");
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String pubName = rs.getString("name");
                String pubCity = rs.getString("city");
                System.out.printf("%s, %s%n", pubName, pubCity);
            }
            rs.close();

            stmt.close();
            conn.close();;
        } catch (SQLException e){
            System.err.println(e);
        }
    }
}
