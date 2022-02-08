package QLY.Leetcode.array;

public class IncreasingTripletSubsequence {
//    public boolean increasingTriplet(int[] nums) {
//        if (nums.length < 3)
//            return false;
//
//        boolean[] dp = new boolean[nums.length];    // 是否存在以i结尾的升序子序列
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                if (nums[j] >= nums[i])
//                    continue;
//                if (dp[j])
//                    return true;
//                dp[i] = true;
//            }
//        }
//
//        return false;
//    }

    // 贪心策略
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;

        int first = nums[0];
        Integer second = null;
        for (int i = 1; i < nums.length; i++) {

            if (second == null) {
                if (nums[i] > first)
                    second = nums[i];
                else if (nums[i] < first)
                    first = nums[i];
            }else {
                if (nums[i] > second)
                    return true;
                else if (nums[i] < second && nums[i] > first)
                    second = nums[i];
                else if (nums[i] < first)
                    first = nums[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{2,1,5,0,4,6}));
    }
}
