package com.example.prac.chapter02.FromMapToExcel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class FromMapToExcel {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        load(map, "/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/FromMapToExcel/Countries.dat");
        print(map);
        storeXL(map, "/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/data/Countries.xls", "Countries Worksheet");
    }

    private static void storeXL(Map<String, Integer> map, String fileSpec, String sheet) {
        try {
            FileOutputStream out = new FileOutputStream(fileSpec);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet workSheet = workbook.createSheet(sheet);
            Set<String> countries = map.keySet();
            short rowNum = 0;
            for (String country : countries){
                Integer population = map.get(country);
                HSSFRow row = workSheet.createRow(rowNum);
                row.createCell(0).setCellValue(country);
                row.createCell(1).setCellValue(population);
                ++rowNum;
            }
            workbook.write(out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void print(Map<String, Integer> map) {
        Set<String> countries = map.keySet();
        for (Object country : countries){
            Object population = map.get(country);
            System.out.printf("%-10s%,12d%n", country, population);
        }
    }

    private static void load(Map<String, Integer> map, String fileSpec) {
        File file = new File(fileSpec);
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()) {
                String country = input.next();
                int population = input.nextInt();
                map.put(country, population);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }


}
