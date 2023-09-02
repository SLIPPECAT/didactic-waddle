package com.example.prac.chapter03;

import lombok.Getter;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TimeSeries<T> implements Iterable<TimeSeries.Entry> {
    private final Map<Long, T>  map = new TreeMap<>();

    public void add(long time, T event){
        map.put(time, event);
        try {
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public T get(long time){
        return map.get(time);
    }

    ArrayList getList(){
        ArrayList<TimeSeries.Entry> list = new ArrayList<>();
        for (TimeSeries.Entry entry : this){
            list.add(entry);
        }
        return list;
    }

    public int size() {
        return map.size();
    }

    @Override
    public Iterator iterator() {
        return new Iterator(){
            private final Iterator it = map.keySet().iterator();

            @Override
            public boolean hasNext(){
                return it.hasNext();
            }

            @Override
            public Entry<T> next() {
                long time = (long) it.next();
                T event = map.get(time);
                return new Entry(time, event);
            }
        };
    }

    @Getter
    public static class Entry<T> {
        private final long time;
        private final T event;

        public Entry(long time, T event) {
            this.time = time;
            this.event = event;
        }

        @Override
        public String toString(){
            return String.format("(%d, %s)", time, event);
        }
    }
}
