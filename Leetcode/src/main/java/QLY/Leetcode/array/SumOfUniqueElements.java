package QLY.Leetcode.array;

/**
 * https://leetcode-cn.com/problems/sum-of-unique-elements/
 * 1748. 唯一元素的和
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 */
public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        int[] ct = new int[101];
        for (int num : nums) {
            ct[num]++;
        }
        int sum = 0;
        for (int i = 0; i < ct.length; i++) {
            if (ct[i] == 1)
                sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfUniqueElements sum = new SumOfUniqueElements();
        System.out.println(sum.sumOfUnique(new int[]{10}));
    }
}
