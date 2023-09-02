package com.example.prac.chapter03;

import java.util.Iterator;

public class MovingAverage extends TimeSeries<Double>{
    private final TimeSeries parent;
    private final int length;

    public MovingAverage(TimeSeries parent, int length) {
        this.parent = parent;
        this.length = length;
        if (length > parent.size()){
            throw new IllegalArgumentException("길이가 너무 깁니다.");
        }

        double[] tmp = new double[length];
        double sum = 0;
        int i = 0 ;
        Iterator it = parent.iterator();
        // 처음 값은 차례대로 세 개 계산
        for (int j = 0; j < length; j++){
            sum += tmp[i++] = nextValue(it);
        }
        this.add(System.currentTimeMillis(), sum/length);

        // 다음 값 평균 계산할 경우 가장 오래된 값은 제외하고, 다음 값은 더해준다.
        while(it.hasNext()){
            sum -= tmp[i%length];
            sum += tmp[i++%length] = nextValue(it);
            this.add(System.currentTimeMillis(), sum/length);
        }
    }

    private static double nextValue(Iterator it) {
        TimeSeries.Entry<Double> entry = (TimeSeries.Entry) it.next();
        return entry.getEvent();
    }


}
