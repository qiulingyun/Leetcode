package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/word-break-ii/
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new LinkedList<>();
        backtrace(s, wordDict, new LinkedList<>(), results);
        return results;
    }

    private void backtrace(String s, List<String> wordDict, LinkedList<String> path, List<String> results){
        if (s.isEmpty()){
            String sentence = String.join(" ", path);
            results.add(sentence);
            return;
        }
        for (String word: wordDict){
            if (s.startsWith(word)){
                path.add(word);
                String left = s.substring(word.length());
                backtrace(left, wordDict, path, results);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        WordBreak2 wb = new WordBreak2();
        System.out.println(wb.wordBreak("pineapplepenapple", new ArrayList<String>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"))));
    }
}
