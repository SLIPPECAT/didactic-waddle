package com.example.prac.chapter02.SortingData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class SortingData {
    public static void main(String[] args) {
        File file = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/SortingData/Countries.dat");
        TreeMap<Integer, String> dataset = new TreeMap<>();
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()){
                String x = input.next();
                int y = input.nextInt();
                dataset.put(y, x);
            }
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        print(dataset);
    }

    private static void print(TreeMap<Integer, String> dataset) {
        for (Integer key : dataset.keySet()){
            System.out.printf("%,12d %-16s%n", key, dataset.get(key));
        }
    }


}
