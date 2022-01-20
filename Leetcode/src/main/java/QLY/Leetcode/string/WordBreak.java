package QLY.Leetcode.string;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty())
            return true;

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String left = s.substring(word.length());
                if (wordBreak(s.substring(word.length()), wordDict))
                    return true;
            }
        }
        return false;
    }

//    private boolean backtrace(String curr, List<String> wordDict){
//        if (curr.isEmpty())
//            return true;
//
//        for (String word : wordDict) {
//            if (curr.startsWith(word)) {
//                String left = curr.substring(word.length());
//                if (backtrace(curr.substring(word.length()), wordDict))
//                    return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }
}
