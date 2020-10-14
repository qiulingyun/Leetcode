package QLY.Leetcode;

public class LengthOfLIS {

//    输入: [10,9,2,5,3,7,101,18]
//    输出: 4
//    解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        int[] tail = new int[nums.length];
        dp[0] = 1;
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            int maxL = 1, minTail = nums[i];
            for (int j = 0; j < i; j++){
                if (tail[j] < nums[i] && dp[j] + 1 > maxL){
                    maxL = Math.max(maxL, dp[j] + 1 );
                    minTail = Math.min(minTail, nums[i]);
                }
            }
            dp[i] = maxL;
            tail[i] = minTail;
        }

        int maxL = 0;
        for (int m: dp){
            maxL = Math.max(maxL, m);
        }
        return maxL;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
