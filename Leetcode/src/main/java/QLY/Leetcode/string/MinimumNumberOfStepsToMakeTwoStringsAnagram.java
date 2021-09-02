package QLY.Leetcode.string;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    /**
     * https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
     */

    public int minSteps(String s, String t) {
        int[] ns = new int[26];
        int[] nt = new int[26];
        for (char c: s.toCharArray()) {
            ns[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            nt[c - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++){
            count += Math.abs(ns[i] - nt[i]);
        }
        return count/2;
    }

    public static void main(String[] args) {
        MinimumNumberOfStepsToMakeTwoStringsAnagram obj = new MinimumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.println(obj.minSteps("leetcode", "practice"));
        System.out.println(obj.minSteps("anagram", "mangaar"));
    }
}
