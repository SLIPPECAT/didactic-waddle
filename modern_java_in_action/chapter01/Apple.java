package modern_java_in_action.chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static modern_java_in_action.chapter01.AppleColor.GREEN;

public class Apple {

    private AppleColor color;

    private int weight;

    public AppleColor getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

//    public static List<Apple> filterHeavyApples(List<Apple> inventory){
//        List<Apple> result = new ArrayList<>();
//
//        for (Apple apple : inventory) {
//            if (GREEN.equals(apple.getColor()))
//                result.add(apple);
//        }
//        for (Apple apple : inventory) {
//            if (apple.getWeight() > 150) {
//                result.add(apple);
//            }
//        }
//        return result;
//    }

    public static boolean isGreenApple(Apple apple){
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }
    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
