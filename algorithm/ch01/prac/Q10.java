package algorithm.ch01.prac;

import java.util.Scanner;

public class Q10 {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("양의 정수를 입력해주세요.");
        int inputNumber = stdIn.nextInt();
        int count = 0;

        while (inputNumber > 0){
            inputNumber = inputNumber / 10;
            count++;
        }
//        int count = 1;
//
////        do {
////            n = n / 10;
////            count += 1;
////        } while(n > 10);

        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
