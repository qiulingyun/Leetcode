package QLY.Leetcode.string;

import java.util.Stack;
import java.util.StringJoiner;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 *
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (char c: s.toCharArray()){
            if (c == ' '){
                if (sb.length() != 0){
                    stack.push(sb.toString());
                    sb = new StringBuffer();
                }

                continue;
            }
            sb.append(c);
        }

        if (sb.length() != 0){
            stack.push(sb.toString());
            sb = new StringBuffer();
        }

        StringJoiner sj = new StringJoiner(" ");
        while (!stack.isEmpty()){
            sj.add(stack.pop());
        }

        return sj.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords("a good   example"));
        System.out.println(reverseWordsInAString.reverseWords("  Bob    Loves  Alice   "));
        System.out.println(reverseWordsInAString.reverseWords("Alice does not even like bob"));
    }
}
