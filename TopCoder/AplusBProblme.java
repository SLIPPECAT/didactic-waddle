package TopCoder;
import java.util.*;

import java.util.Map;

class AplusBProble{
    
    public int clac(int a, int b){
        return a + b;
    }

    public static void countStrings(String[] s){

        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < s.length; i++) {
            if (!hm.containsKey(s[i])) hm.put(s[i], 0);
            hm.put(s[i], hm.get(s[i] + 1));
        }
        for (String key : hm.keySet()){
            System.out.println(key + " " + hm.get(key));
        }
    }

    public static void main(String[] args) {
        
        String[] s = {"류준영", "류준영", "김호연", "허지성"};
        countStrings(s);

    }

}