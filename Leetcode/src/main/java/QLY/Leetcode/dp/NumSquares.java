package QLY.Leetcode.dp;

public class NumSquares {
    public int numSquares(int n) {
        if (n <= 0 )
            return 0;
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++){
                min = Math.min(min, dp[i-j*j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(13));
    }
}
