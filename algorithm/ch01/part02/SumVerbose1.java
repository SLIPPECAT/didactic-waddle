package algorithm.ch01.part02;

import java.util.Scanner;

// 반복 과정에서 조건 판단하기
public class SumVerbose1 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.print("n값: ");
            n = stdIn.nextInt();
        } while(n <=0);

        int sum = 0;

        // 마지막 과정을 위해 반복문을 엄청 돌려야 한다.
//        for (int i = 1; i <= n; i++) {
//            if (i < n){
//                // 중간 과정
//                System.out.print(i + " + ");
//            } else {
//                // 마지막 과정
//                System.out.print(i + " = ");
//            }
//            // sum에 i를 더함
//            sum += i;
//            System.out.println(sum);
//
//        }

        // 이게 조금 더 바람직한 방법
        for (int i = 1; i < n; i++) {
            System.out.print(i + " + ");
            sum += i;  // sum에 i를 더함
        }

//        System.out.println(n + " = ");
//        sum += n;  // sum에 n을 더함
//        System.out.println(sum);

        System.out.println(n + " = " + (sum += n));
    }
}
