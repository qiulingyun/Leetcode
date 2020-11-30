package QLY.Leetcode.dp;

import java.util.stream.Collectors;

/**
 * 518. 零钱兑换 II
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;

        for (int i = 1; i < dp.length; i++){
            for (int amt = 1; amt <=amount; amt++){
                if (coins[i-1] > amt){
                    dp[i][amt] = dp[i-1][amt];
                }else {
                    // warning!  dp[i][amt-coins[i-1]],  not dp[i-1][amt-coins[i-1]]  !!!
                    dp[i][amt] = dp[i-1][amt] + dp[i][amt-coins[i-1]];
                }

            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.change(5, new int[]{1, 2, 5}));
    }
}
