package algorithm.ch01.prac;

import java.util.Scanner;

// 가우스의 덧셈
public class Q7 {

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);
        System.out.println("가우스의 덧셈");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

        int sum = 0;

        System.out.println("1부터 n까지의 합");
        sum = n * (n + 1) / 2;

        System.out.println("sum = " + sum);
    }
}
