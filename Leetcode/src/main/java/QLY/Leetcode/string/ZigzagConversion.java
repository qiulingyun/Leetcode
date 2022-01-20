package QLY.Leetcode.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 0           8
 * 1        7
 * 2     6
 * 3  5
 * 4
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        ArrayList<Character>[] lists = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++){
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = 0;
            if (numRows != 1)
                index = i % (2 * numRows - 2);
            if (index < numRows){
                lists[index].add(c);
            }else {
                lists[2 * numRows - 2 - index].add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for (ArrayList<Character> list :lists) {
            result.append(list.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("A", 1));
    }
}
