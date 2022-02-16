package QLY.Leetcode.array;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int lowbit = lowbit(xor);
        int left = 0, right = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0)
                left ^= num;
            else
                right ^= num;
        }

        return new int[]{left, right};
    }

    private static int lowbit(int x){
        return x == Integer.MIN_VALUE? Integer.MIN_VALUE: x & (-x);
    }
}
