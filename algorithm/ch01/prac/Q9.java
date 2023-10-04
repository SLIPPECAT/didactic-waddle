package algorithm.ch01.prac;

import java.util.Scanner;

public class Q9 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("a값: ");
        int a = stdIn.nextInt();
        System.out.print("b값: ");
        int b = stdIn.nextInt();

        do {
            System.out.println("a보다 큰 값을 입력하세요.");
            System.out.print("b값: ");
            b = stdIn.nextInt();
        } while(a >= b);

        System.out.println("b-a는 " + (b-a) + "입니다.");
    }

}
