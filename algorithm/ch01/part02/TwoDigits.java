package algorithm.ch01.part02;

import java.util.Scanner;

// 논리 연산과 드모르간 법칙
// 2자리 양수를 입력받는 프로그램
public class TwoDigits {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;

        System.out.println("2자리의 양수를 입력하세요.");
        do {
            System.out.print("no값: ");
            no = stdIn.nextInt();
        } while (no < 10 || no > 99);

        System.out.println("변수 no값은 " + no + "이 되었습니다.");
    }
}
