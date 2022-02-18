package QLY.Leetcode.prefix;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 * 1248. 统计「优美子数组」
 * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中 「优美子数组」 的数目。
 */
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        final int n = nums.length;
        int[] pre = new int[n];   //截至第i位有多少奇数
        pre[0] = nums[0] % 2;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i] % 2;
        }

        int result = 0;
        HashMap<Integer, Integer> odds = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (pre[i] == k)
                result++;
            result += odds.getOrDefault(pre[i] - k, 0);
            Integer curr = odds.getOrDefault(pre[i], 0);
            curr = curr + 1;
            odds.put(pre[i], curr);
        }

        return result;
    }

    public static void main(String[] args) {
        CountNumberOfNiceSubarrays countNumberOfNiceSubarrays = new CountNumberOfNiceSubarrays();
        System.out.println(countNumberOfNiceSubarrays.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
//        System.out.println(countNumberOfNiceSubarrays.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    }
}
