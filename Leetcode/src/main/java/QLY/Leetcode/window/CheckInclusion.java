package QLY.Leetcode.window;

import java.util.HashMap;

/**
 * 567. 字符串的排列
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        final int LENGTH = s1.length();
        int left = 0;
        HashMap<Character, Integer> windowMap = new HashMap<>();
        s2.substring(0, LENGTH).chars().mapToObj(o->(char)o).forEach(o->{
            if (windowMap.containsKey(o)){
                windowMap.compute(o, (k,v)->v+1);
            }else {
                windowMap.put(o, 1);
            }
        });

        if (windowContainsTarget(windowMap, s1)){
            return true;
        }

        while (left + LENGTH < s2.length()) {

            // Sliding window
            Character leftc = s2.charAt(left);

            if (windowMap.get(leftc) == 1){
                windowMap.remove(leftc);
            }else {
                windowMap.compute(leftc, (k,v)->v-1);
            }

            Character rightc = s2.charAt(left + LENGTH);
            if (windowMap.containsKey(rightc)){
                windowMap.compute(rightc, (k,v)->v+1);
            }else {
                windowMap.put(rightc, 1);
            }
            left++;

            if (windowContainsTarget(windowMap, s1)){
                return true;
            }

        }
        return false;
    }

    private boolean windowContainsTarget(HashMap<Character, Integer> windowMap, String target){
        HashMap<Character, Integer> tempMap = new HashMap<>(windowMap);
        for (char o : target.toCharArray()){
            if (!tempMap.containsKey(o)){
                return false;
            }else {
                if (tempMap.get(o) == 1){
                    tempMap.remove(o);
                }else {
                    tempMap.compute(o, (k,v)->v-1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("ab", "a"));
    }
}
