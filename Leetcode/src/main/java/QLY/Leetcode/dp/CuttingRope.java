package QLY.Leetcode.dp;

public class CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], j * dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.cuttingRope(12));
    }
}
