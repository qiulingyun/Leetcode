package QLY.Leetcode.window;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        if(s == null || s.isEmpty())
            return null;

        HashMap<Character, Integer> targetMap = new HashMap<>();
        t.chars().mapToObj(o->(char)o).forEach(o->{
            if (targetMap.containsKey(o)){
                targetMap.compute(o, (k,v)->v+1);
            }else {
                targetMap.put(o, 1);
            }
        });



        // window [left, right]
        int left = 0, right = 0;
        String window = "", result = "";
        HashMap<Character, Integer> windowMap = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right++);
            window += c;
            if (!windowMap.containsKey(c)){
                windowMap.put(c, 1);
            }else {
                windowMap.compute(c, (k,v)->v+1);
            }

            while (windowContainsTarget(windowMap, targetMap)){
                char d = s.charAt(left++);
                window = window.substring(1);
                if (windowMap.get(d) == 1){
                    windowMap.remove(d);
                }else {
                    windowMap.compute(d, (k,v)->v-1);
                }

                // shrink to unfulfill the target
                if (!windowContainsTarget(windowMap, targetMap)){
                    if (result.isEmpty() || result.length() > window.length() + 1){
                        result = d + window;
                    }
                }
            }
        }

        return result;
    }

    private boolean windowContainsTarget(HashMap<Character, Integer> window, HashMap<Character, Integer> target){
        Map.Entry<Character, Integer> characterIntegerEntry = target.entrySet().stream().filter(t -> {
            if (!window.containsKey(t.getKey())) {
                return true;
            } else if (window.get(t.getKey()) < t.getValue()) {
                return true;
            }
            return false;
        }).findAny().orElse(null);

        if (characterIntegerEntry != null)
            return false;

        return true;

    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("a", "aa"));
    }
}
