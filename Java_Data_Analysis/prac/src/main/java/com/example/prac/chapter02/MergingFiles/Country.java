package com.example.prac.chapter02.MergingFiles;

import java.util.Scanner;

public class Country implements Comparable{
    protected String name;
    protected int population;

    public Country(Scanner in){
        if (in.hasNextLine()){
            this.name = in.next();
            this.population = in.nextInt();
        }
    }
    public boolean isNull(){
        return this.name == null;
    }

    @Override
    public int compareTo(Object o) {
        Country that = (Country) o;
        return this.population - that.population;
    }

    @Override
    public String toString() {
        return String.format("%-10s %, 12d", name, population);
    }
}
