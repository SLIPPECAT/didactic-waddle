package Java_Data_Analysis.chapter02.HashMapExample1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        File dataFile = new File("Java_Data_Analysis/chapter02/HashMapExample1/Countries.dat");
        HashMap<String, Integer> dataset = new HashMap<>();
        try {
            Scanner input = new Scanner(dataFile);
            while(input.hasNext()){
                String country = input.next();
                int popular = input.nextInt();
                dataset.put(country, popular);
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        System.out.printf("dataset.size(): %d%n", dataset.size());
        System.out.printf("dataset.get(\"Peru\"): %,d%n", dataset.get("Peru"));
        dataset.put("Peru", 31000000);
        System.out.printf("dataset.size(): %d%n", dataset.size());
        System.out.printf("dataset.get(\"Peru\"): %,d%n", dataset.get("Peru"));
    }
}
