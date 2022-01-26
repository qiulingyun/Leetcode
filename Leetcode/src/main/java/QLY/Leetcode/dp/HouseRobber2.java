package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        // choose 0
        int dp = 0, dp1 = 0, max1 = 0;
        for (int i = 2; i < nums.length - 1; i++) {
            int temp = dp;
            dp = Math.max(dp, dp1 + nums[i]);
            dp1 = temp;

            max1 = Math.max(max1, dp);
        }
        max1 += nums[0];

        // not choose 0
        dp = 0;
        dp1 = 0;
        int max2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = dp;
            dp = Math.max(dp, dp1 + nums[i]);
            dp1 = temp;

            max2 = Math.max(max2, dp);
        }
        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        HouseRobber2 houseRobber2 = new HouseRobber2();
        System.out.println(houseRobber2.rob(new int[]{1, 2, 3, 0}));
    }
}
