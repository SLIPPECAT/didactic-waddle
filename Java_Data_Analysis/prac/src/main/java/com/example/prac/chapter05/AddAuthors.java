package com.example.prac.chapter05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class AddAuthors {
    private static final String URL = "jdbc:sqlite:/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/jdbctest.db";
    private static final String USR = "admin";
    private static final String PWD = "admin";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USR, PWD);
            File file = new File("data/Authors.dat");
            String sql = "insert into Authors Values(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            Scanner fileScanner = new Scanner(file);
            int rows = 0;
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line).useDelimiter("/");
                String id = lineScanner.next();
                String lastName = lineScanner.next();
                String firstName = lineScanner.next();
                int yob = lineScanner.nextInt();
                ps.setString(1, id);
                ps.setString(2, lastName);
                ps.setString(3, firstName);
                ps.setInt(4, yob);
                rows += ps.executeUpdate();
                lineScanner.close();
            }
            System.out.printf("%d 행이 Authors 테이블에 저장됨%n", rows);
            fileScanner.close();
            conn.close();;
        } catch (SQLException | IOException e) {
            System.err.println(e);
        }
    }
}
