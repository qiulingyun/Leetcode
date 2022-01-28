package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/minimum-swaps-to-make-sequences-increasing/
 * 801. 使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整型数组 A 和 B 。
 * 我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
 * 在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
 * 给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。
 */
public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] dp = new int[n][2];  // dp[i][0] 为i 位置的未交换时最小交换次数，dp[i][1] 为i 位置交换时的最小次数
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;

            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]){
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            }

            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]){
                dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + 1);
            }

        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public static void main(String[] args) {
        MinimumSwapsToMakeSequencesIncreasing min = new MinimumSwapsToMakeSequencesIncreasing();
        System.out.println(min.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));
        /**
         * [0,4,4,5,9]
         * [0,1,6,8,10]
         */
        System.out.println(min.minSwap(new int[]{0,4,4,5,9}, new int[]{0,1,6,8,10}));
    }
}
