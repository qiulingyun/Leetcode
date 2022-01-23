package QLY.Leetcode.graph;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];

        queue.add(amount);
        visited[amount] = true;
        int step = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int coin : coins) {
                    if (coin == curr)
                        return step;
                    else if (coin > curr)
                        continue;

                    int left = curr - coin;
                    if (visited[left])
                        continue;

                    visited[left] = true;
                    queue.add(left);
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1}, 2));
    }
}
