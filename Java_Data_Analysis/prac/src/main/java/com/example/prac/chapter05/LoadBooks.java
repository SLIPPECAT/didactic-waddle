package com.example.prac.chapter05;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LoadBooks {
    private static final String URL = "jdbc:sqlite:/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/jdbctest.db";
    private static final String USR = "admin";
    private static final String PWD = "admin";
    private static final File DATA = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter05/data/Books.dat");
    private static final String SQL = "insert into Books values(?, ?, ?, ?, ?, ?, ?)";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USR, PWD);
            PreparedStatement ps = conn.prepareStatement(SQL);
            Scanner fileScanner = new Scanner(DATA);
            conn.createStatement().execute("delete from AuthorsBooks");
            conn.createStatement().execute("delete from Books");
            int rows = 0;
            while(fileScanner.hasNext()){
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line).useDelimiter("/");
                String title = lineScanner.next();
                int edition = lineScanner.nextInt();
                String cover = lineScanner.next();
                String publicsher = lineScanner.next();
                int pubYear = lineScanner.nextInt();
                String isbn = lineScanner.next();
                int numPages = lineScanner.nextInt();
                ps.setString(1, title);
                ps.setInt(2, edition);
                ps.setString(3, cover);
                ps.setString(4, publicsher);
                ps.setInt(5, pubYear);
                ps.setString(6, isbn);
                ps.setInt(7, numPages);
                rows += ps.executeUpdate();
                lineScanner.close();
            }
            System.out.printf("%d 행이 Books 테이블에 저장됨%n", rows);
            fileScanner.close();
            conn.close();;
        } catch (SQLException | IOException e) {
            System.err.println(e);
        }
    }
}
