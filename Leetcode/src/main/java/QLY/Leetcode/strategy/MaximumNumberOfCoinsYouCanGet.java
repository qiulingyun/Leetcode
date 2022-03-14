package QLY.Leetcode.strategy;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
 * 1561. 你可以获得的最大硬币数目
 * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
 *
 * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 * Alice 将会取走硬币数量最多的那一堆。
 * 你将会取走硬币数量第二多的那一堆。
 * Bob 将会取走最后一堆。
 * 重复这个过程，直到没有更多硬币。
 * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
 *
 * 返回你可以获得的最大硬币数目
 */
public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int results = 0;
        for (int i = piles.length - 2, j = 0; i > j; i-=2, j++) {
            results += piles[i];
        }

        return results;
    }

    public static void main(String[] args) {
        MaximumNumberOfCoinsYouCanGet max = new MaximumNumberOfCoinsYouCanGet();
        System.out.println(max.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
        System.out.println(max.maxCoins(new int[]{2,4,5}));
    }
}
