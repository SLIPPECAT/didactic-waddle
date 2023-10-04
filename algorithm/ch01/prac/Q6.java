package algorithm.ch01.prac;

import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합 구하기");
        System.out.print("n값: ");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;

        while(i <= n) {
            sum += i;
            i++;
            System.out.println("i = " + i + ", n + 1= " + (n + 1));
        }
        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");

    }

}
