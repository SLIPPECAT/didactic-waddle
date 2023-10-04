package algorithm.ch01.prac;

import java.util.Scanner;

public class Q8 {

    static int sumof(int a, int b){
        // a가 3, b가 5 면 12
        // a가 6, b가 4면 15
        int sum = 0;
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            sum += i;
        }

//        if (b > a) {
//            for (int i = a; i <= b; i++) {
//                sum += i;
//            }
//        } else {
//            for (int i = b; i <= a; i++) {
//                sum += i;
//            }
//        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a값: ");
        int a = stdIn.nextInt();
        System.out.print("b값: ");
        int b = stdIn.nextInt();

        int sum = sumof(a, b);

        System.out.println("a와 b의 총합: " + sum);

    }
}
