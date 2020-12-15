package QLY.Leetcode.greedy;

/**
 * 738. 单调递增的数字
 * 难度 中等
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] str = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < str.length && str[i-1] <= str[i]){
            i++;
        }
        if (i < str.length){
            while (i >= 1 && str[i-1] > str[i]){
                str[i-1] -= 1;
                i--;
            }
            i++;
            while (i < str.length){
                str[i++] = '9';
            }
        }

        return Integer.parseInt(new String(str));
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
        System.out.println(monotoneIncreasingDigits.monotoneIncreasingDigits(10));
    }
}
