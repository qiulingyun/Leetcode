package QLY.Leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 * 187. 重复的DNA序列
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 */
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() < 10)
            return results;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String substring = s.substring(i, i + 10);
            if (map.containsKey(substring)){
                if (map.get(substring) == 1){
                    map.put(substring, 2);
                    results.add(substring);
                }
            }else {
                map.put(substring, 1);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        RepeatedDnaSequences r = new RepeatedDnaSequences();
        System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
