package QLY.Leetcode.dp;

/**
 * 978. 最长湍流子数组
 * 难度 中等
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 * 示例 1：
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * 输入：[100]
 * 输出：1
 *
 * 提示：
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1)
            return 1;
        //以i结尾的最长长度
        int[] dp = new int[arr.length];
        dp[0] = 1;
        if (arr[1] != arr[0])
            dp[1] = 2;
        else
            dp[1] = 1;

        for (int i = 2; i < arr.length; i++ ){
            if (arr[i] > arr[i-1] && arr[i-1] < arr[i-2] ||
                    arr[i] < arr[i-1] && arr[i-1] > arr[i-2]){
                dp[i] = dp[i-1] + 1;
            }else {
                if (arr[i] != arr[i-1])
                    dp[i] = 2;
                else
                    dp[i] = 1;
            }
        }
        int max = 1;
        for (int l: dp){
            if (l > max)
                max = l;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(new int[]{4,8,12,16}));
        System.out.println(longestTurbulentSubarray.maxTurbulenceSize(new int[]{9,9}));
    }
}
