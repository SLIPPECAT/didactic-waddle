package com.example.prac.chapter02.FromExcelToMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FromExcelToMap {
    public static void main(String[] args) {
        Map map = loadXL("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/data/Countries.xls", "Countries Worksheet");
        print(map);
    }

    private static void print(Map map) {
        Set<String> countries = map.keySet();
        for (String country : countries){
            Object population = map.get(country);
            System.out.printf("%-10s%,12d%n", country, population);
        }
    }

    private static Map loadXL(String fileSpec, String sheet) {
        Map<String, Integer> map = new TreeMap<>();
        try {
            FileInputStream input = new FileInputStream(fileSpec);
            HSSFWorkbook workbook = new HSSFWorkbook(input);
            HSSFSheet worksheet = workbook.getSheet(sheet);
            DataFormatter formatter = new DataFormatter();
            for (Row row : worksheet){
                HSSFRow hssfRow = (HSSFRow) row;
                HSSFCell cell = hssfRow.getCell(0);
                String country = cell.getStringCellValue();
                cell = hssfRow.getCell(1);
                String str = formatter.formatCellValue(cell);
                int population = Integer.parseInt(str);
                map.put(country, population);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
        return map;
    }
}
