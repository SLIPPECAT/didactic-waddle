package com.example.prac.chapter05;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class LoadPublishers {
    private static final String URL = "jdbc:sqlite:/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/jdbctest.db";
    private static final String USR = "admin";
    private static final String PWD = "admin";
    private static final File DATA = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter05/data/Publishers.dat");
    private static final String SQL = "insert into Publishers values(?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USR, PWD);
            PreparedStatement ps = conn.prepareStatement(SQL);
            Scanner fileScanner = new Scanner(DATA);
            conn.createStatement().execute("delete from AuthorsBooks");
            conn.createStatement().execute("delete from Books");
            conn.createStatement().execute("delete from Publishers");
            int rows = 0;
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line).useDelimiter("/");
                String id = lineScanner.next();
                String name = lineScanner.next();
                String city = lineScanner.next();
                String country = lineScanner.next();
                String url = (lineScanner.hasNext() ? lineScanner.next() : "");
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, city);
                ps.setString(4, country);
                if (url.length() > 0){
                    ps.setString(5, url);
                } else {
                    ps.setNull(5, Types.VARCHAR);
                }
                rows += ps.executeUpdate();
                lineScanner.close();
            }
            System.out.printf("%d 행이 Publishers 테이블에 저장됨%n", rows);
            conn.close();
        } catch(SQLException | FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }



}
