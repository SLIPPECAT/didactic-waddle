package com.example.prac.chapter05;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoadAuthors {
    private static final String URL = "jdbc:sqlite:/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/jdbctest.db";
    private static final String USR = "admin";
    private static final String PWD = "admin";
    private static final File DATA = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter05/data/Authors.dat");
    private static final String SQL = "insert into Authors values(?, ?, ?, ?)";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USR, PWD);
            PreparedStatement ps = conn.prepareStatement(SQL);
            Scanner fileScanner = new Scanner(DATA);
            conn.createStatement().execute("delete from AuthorsBooks");
            conn.createStatement().execute("delete from Authors");
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
