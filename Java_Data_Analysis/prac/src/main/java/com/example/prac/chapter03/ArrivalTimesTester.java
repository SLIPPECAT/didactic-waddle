package com.example.prac.chapter03;

import java.util.Random;

public class ArrivalTimesTester {
    static final Random random = new Random();
    static final double LAMBDA = 0.25;

    static double time() {
        double p = random.nextDouble();
        return -Math.log(1 - p)/LAMBDA;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++){
            System.out.println(time());
        }
        double k = 10.317862886151195+ 1.3112125738846203+ 0.40346869346887604+ 10.504097077827689+ 2.731748524159465+ 7.666507785563641+ 4.112870146916453+ 0.10788512609084418;
        System.out.println(k/8);
    }

}
