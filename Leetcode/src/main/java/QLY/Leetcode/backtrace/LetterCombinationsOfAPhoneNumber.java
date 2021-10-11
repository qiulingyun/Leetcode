package QLY.Leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LetterCombinationsOfAPhoneNumber {
    //输入：digits = "23"
    //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        List<String> answer = new ArrayList<>();
        char[][] phonemap = new char[][]{
                {}, //0
                {}, //1
                {'a', 'b', 'c'}, //2
                {'d', 'e', 'f'}, //3
                {'g', 'h', 'i'}, //4
                {'j', 'k', 'l'}, //5
                {'m', 'n', 'o'}, //6
                {'p', 'q', 'r', 's'}, //7
                {'t', 'u', 'v'}, //8
                {'w', 'x', 'y', 'z'}, //9
        };

        backtrace(digits.toCharArray(), phonemap, 0, new StringBuffer(), answer);
        return answer;
    }

    private void backtrace(char[] digits, char[][] phonemap, int curr, StringBuffer path, List<String> answer){
        if (curr >= digits.length){
            answer.add(path.toString());
            return;
        }


        int digit = (digits[curr] - '0');

        for (int i = 0; i < phonemap[digit].length; i++){
            char choice = phonemap[digit][i];
            path.append(phonemap[digit][i]);

            backtrace(digits, phonemap, curr+1, path, answer);

            path.deleteCharAt(path.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(""));
    }
}
