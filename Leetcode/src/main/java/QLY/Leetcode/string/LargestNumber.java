package QLY.Leetcode.string;

import java.util.PriorityQueue;
import java.util.StringJoiner;

/**
 * https://leetcode-cn.com/problems/largest-number/
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
//        PriorityQueue<String> queue = new PriorityQueue<>((a, b)->{
//            int i = 0, j = 0;
//            while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)){
//                if (i + 1 == a.length() && j + 1 < b.length())
//                    j++;
//                else if(i + 1 < a.length() && j + 1 == b.length())
//                    i++;
//                else if(i + 1 < a.length() && j + 1 < b.length()){
//                    i++;
//                    j++;
//                }
//                else
//                    return 0;
//            }
//            return b.charAt(j) - a.charAt(i);
//        });
        PriorityQueue<String> queue = new PriorityQueue<>((a, b)->{
            return (int) (Long.parseLong(b + a) - Long.parseLong(a + b));
        });
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }

        StringJoiner sj = new StringJoiner("");
        while (!queue.isEmpty()){
            sj.add(queue.poll());
        }
        String str = sj.toString();
        int i = 0;
        while (i < str.length() - 1 && str.charAt(i) == '0')
            i++;

        return str.substring(i);
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber.largestNumber(new int[]{0, 0}));
    }
}
