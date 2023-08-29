package com.example.prac.chapter02.MergingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MergingFiles {
    public static void main(String[] args) {
        File inFile1 = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/MergingFiles/Countries1.dat");
        File inFile2 = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/MergingFiles/Countries2.dat");
        File outFile = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/MergingFiles/CountriesMerged.dat");
        try{
            Scanner in1 = new Scanner(inFile1);
            Scanner in2 = new Scanner(inFile2);
            PrintWriter out = new PrintWriter(outFile);
            Country country1 = new Country(in1);
            Country country2 = new Country(in2);
            while(!country1.isNull() && !country2.isNull()) {
                if (country1.compareTo(country2) < 0) {
                    out.println(country1);
                    country1 = new Country(in1);
                    System.out.println(country1.hashCode());
                } else {
                    out.println(country2);
                    country2 = new Country(in2);
                }
            }
            while(!country1.isNull()){
                out.println(country1);
                country1 = new Country(in1);
            }
            while (!country2.isNull()){
                out.println(country2);
                country2 = new Country(in2);
            }
            in1.close();
            in2.close();
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
