package QLY.Leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        String pattern = getCountStr(p.toCharArray());
        char[] chars = s.toCharArray();
        final int windowLength = p.length();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i + windowLength - 1 < chars.length; i++) {
            char[] windowedChars = Arrays.copyOfRange(chars, i, i + windowLength);
            String countStr = getCountStr(windowedChars);
            if (pattern.equals(countStr))
                results.add(i);
        }
        return results;
    }

    private String getCountStr(char[] s){
        int[] pct = new int[26];
        for (char c : s) {
            pct[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pct.length; i++) {
            if (pct[i] > 0){
                sb.append(String.valueOf('a' + i)).append(String.valueOf(pct[i]));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        System.out.println(findAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAllAnagramsInAString.findAnagrams("abab", "ab"));
    }
}
