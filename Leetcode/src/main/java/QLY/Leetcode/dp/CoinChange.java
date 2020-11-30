package QLY.Leetcode.dp;

/**
 * 322. 零钱兑换
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0 || coins == null || coins.length == 0)
            return 0;

        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for (int coin: coins){
                if (i - coin >= 0 && dp[i-coin] >= 0){
                    min = Math.min(min, dp[i-coin] + 1);
                }
            }
            if (min == Integer.MAX_VALUE){
                dp[i] = -1;
            }else {
                dp[i] = min;
            }

        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.printf("" +coinChange.coinChange(new int[]{2,2}, 11));
    }
}
