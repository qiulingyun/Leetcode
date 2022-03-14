package QLY.Leetcode.strategy;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
 * 375. 猜数字大小 II
 * 我们正在玩一个猜数游戏，游戏规则如下：
 * 我从 1 到 n 之间选择一个数字。
 * 你来猜我选了哪个数字。
 * 如果你猜到正确的数字，就会 赢得游戏 。
 * 如果你猜错了，那么我会告诉你，我选的数字比你的 更大或者更小 ，并且你需要继续猜数。
 * 每当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。如果你花光了钱，就会 输掉游戏 。
 *
 * 给你一个特定的数字 n ，返回能够 确保你获胜 的最小现金数，不管我选择那个数字 。
 */
public class GuessNumberHigherOrLower2 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];  //猜测数字[i,j] 范围内的最小费用
        // dp[i][i] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = j; k <= i; k++) {
                    int temp = 0;
                    if (k == j){
                        temp = k + dp[k + 1][i];
                    }else if (k == i){
                        temp = k + dp[j][k - 1];
                    }else {
                        temp = k + Math.max(dp[j][k - 1], dp[k + 1][i]);
                    }
                    dp[j][i] = Math.min(dp[j][i], temp);
                }


            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower2 guessNumberHigherOrLower2 = new GuessNumberHigherOrLower2();
        System.out.println(guessNumberHigherOrLower2.getMoneyAmount(10));
    }
}
