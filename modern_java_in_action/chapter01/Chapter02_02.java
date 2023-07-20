package modern_java_in_action.chapter01;

import static modern_java_in_action.chapter01.AppleColor.GREEN;

public class Chapter02_02 {
    public static boolean isGreenApple(Apple apple){
        return GREEN.equals(apple.getColor());
    }
}
