package com.example.prac.chapter02.FilteringData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FilteringData {
    private static final int MIN_AREA = 1000000;

    public static void main(String[] args) {
        File file = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/FilteringData/Countries.dat");
        Set<Country> dataset = readDataset(file);


        for (Country country : dataset){
            if (country.landlocked && country.area >= MIN_AREA) {
                System.out.println(country);
            }
        }
        System.out.println("=====================================");
        dataset.stream().filter(country -> country.landlocked && country.area >=MIN_AREA).forEach(System.out::println);
    }

    private static Set<Country> readDataset(File file) {
        Set<Country> set =  new HashSet<Country>();
        try {
            Scanner input = new Scanner(file);
            input.nextLine();
            while(input.hasNextLine()){
                    set.add(new Country(input));
            }
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return set;
    }
}
