package com.example.prac.chapter03;

import java.util.ArrayList;

public class TimeSeriesTester {
    final static String[] EVENTS = {"It", "was", "the", "best", "of", "times"};

    public static void main(String[] args) {
        TimeSeries<String> series = new TimeSeries();
        Load(series);

        for (TimeSeries.Entry<String> entry : series) {
            long time = entry.getTime();
            String event = entry.getEvent();
            System.out.printf("%16d: %s%n", time, event);
        }
        ArrayList list = series.getList();
        System.out.printf("list.get(3) = %s%n", list.get(3));
    }

    static void Load(TimeSeries<String> series) {
        for (String event : EVENTS){
            series.add(System.currentTimeMillis(), event);
        }
    }

}
