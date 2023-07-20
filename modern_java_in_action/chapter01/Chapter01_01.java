package modern_java_in_action.chapter01;

import java.util.ArrayList;
import java.util.List;

import static modern_java_in_action.chapter01.Apple.filterApples;
import static modern_java_in_action.chapter01.AppleColor.GREEN;

// 코드 넘겨주기
public class Chapter01_01 {
    // 특정 항목을 선택해서 반환하는 동작 : 필터

    public static void main(String[] args) {

        Apple apple = new Apple();
        List<Apple> inventory = new ArrayList<>();

        filterApples(inventory, Apple::isGreenApple);

    }
}
