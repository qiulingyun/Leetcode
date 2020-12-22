package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 * 312. 戳气球
 * 难度 困难
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 求所能获得硬币的最大数量。
 * 说明:
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums.length == 0)
            return 1;
        int[] points = new int[nums.length+2];
        points[0] = points[nums.length+1] = 1;
        System.arraycopy(nums, 0, points, 1, nums.length);
        // (i..j)开区间内最大的coin, i，j为气球号数
        int[][] dp = new int[nums.length+2][nums.length+2];
        for (int i = points.length - 1; i >= 0 ; i--){
            for (int j = i + 1; j < points.length; j++){
                for (int k = i + 1; k < j; k++){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][nums.length+1];
    }

    public static void main(String[] args) {
        BurstBalloons burstBalloons = new BurstBalloons();
        System.out.println(burstBalloons.maxCoins(new int[]{3,1,5,8}));
    }
}
