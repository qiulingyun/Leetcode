package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/delete-and-earn/
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int min = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        int[] count = new int[max-min+1];
        for (int num : nums) {
            count[num-min]++;
        }

        int dp = 0, prev = 0, maxsum = 0;
        for (int i = 1; i < count.length; i++) {
//            if (count[i] == 0)
//                continue;

            int temp = dp;
            dp = Math.max(dp, prev + (i + min) * count[i]);
            maxsum = Math.max(maxsum, dp);

            prev = temp;
        }

        return maxsum;
    }

    public static void main(String[] args) {
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(new int[]{3,1}));
    }
}
