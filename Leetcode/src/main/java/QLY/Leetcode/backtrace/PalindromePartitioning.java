package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        backtrace(s, new LinkedList<>(), results);
        return results;
    }

    private void backtrace(String s, LinkedList<String> path, List<List<String>> results){
        if (s.isEmpty()){
            results.add(new LinkedList<>(path));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
             if (!isPalindrome(substring))
                continue;

            path.add(substring);
            String leftstring = "";
            if (i < s.length())
                leftstring = s.substring(i);

            backtrace(leftstring, path, results);

            path.removeLast();
        }
    }

    private boolean isPalindrome(String s){
        //[left, right]
        int left = 0, right = s.length() - 1;
        while (left <= right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning p = new PalindromePartitioning();
        List<List<String>> ans = p.partition("aab");
        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
}
