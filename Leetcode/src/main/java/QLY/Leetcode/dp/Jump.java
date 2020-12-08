package QLY.Leetcode.dp;

/**
 * 45. 跳跃游戏 II
 * 难度
 * 困难

 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Jump {

    //超出时间限制
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;

        int longest = 0;
        for (int i = 0; i < nums.length - 1 && i <= longest; i++){
            longest = longest < i + nums[i] ? i + nums[i]: longest;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++){
                dp[j] = dp[j] < dp[i] + 1 ? dp[j]: dp[i] + 1;
            }
        }
        return dp[nums.length-1];
    }

    public int jump(int[] nums) {
        int count = 0;
        int longest = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1 && i <= longest; i++){
            longest = Math.max(longest, nums[i]+i);

            if (i == end){
                count++;
                end = longest;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        System.out.println(jump.jump(new int[]{2,3,1,1,4}));
    }
}
