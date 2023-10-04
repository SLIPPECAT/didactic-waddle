package algorithm.ch01.part02;

import java.util.Scanner;

// 반복 과정에서 조건 판단하기 3
public class PrintStars1 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n, w;

        System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");

        do {
            System.out.print("n값: ");
            n = stdIn.nextInt();
        } while (n <= 0);

        do {
            System.out.print("w값: ");
            w = stdIn.nextInt();
        } while (w <= 0 || w > n);

        for (int i = 0; i < n / w; i++) {
            System.out.println("*".repeat(w));
        }
        int rest = n % w;
        if (rest != 0){
            System.out.println("*".repeat(rest));
        }
        // for문을 반보갈 때마다 if문을 실행하므로 효율적이지 않다.
//        for (int i = 0; i < n; i++) {
//            System.out.print("*");
//            if (i % w == w-1){
//                System.out.println();
//            }
//        }
//        if (n % w != 0){
//            System.out.println();
//        }
//        System.out.print("n값: ");
//        n = stdIn.nextInt();
//        System.out.print("w값: ");
//        w = stdIn.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            System.out.print("*");
//            if (i % w == 0){
//                System.out.println();
//            }
//        }
    }


}
