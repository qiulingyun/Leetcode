package QLY.Leetcode.dp;

/**
 * 416. 分割等和子集
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums)
            sum += n;
        if (sum % 2 != 0)
            return false;
        int capacity = sum / 2;

        // dp[i][j] means in choice of nums[i-1], package capacity is j, if is possible to fill in
        boolean[][] dp = new boolean[nums.length+1][capacity+1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = true;

        for (int i = 1; i < dp.length; i++){
            for (int c = 1; c < dp[i].length; c++){
                if (nums[i-1] > c){
                    dp[i][c] = dp[i-1][c];
                }else {
                    dp[i][c] = dp[i-1][c] || dp[i-1][c - nums[i-1]];
                }

            }
        }

        return dp[nums.length][capacity];
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5}));
    }
}
