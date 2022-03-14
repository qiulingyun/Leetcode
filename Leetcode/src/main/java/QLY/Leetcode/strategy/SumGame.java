package QLY.Leetcode.strategy;

/**
 * https://leetcode-cn.com/problems/sum-game/
 * 1927. 求和游戏
 * Alice 和 Bob 玩一个游戏，两人轮流行动，Alice 先手 。
 * 给你一个 偶数长度 的字符串 num ，每一个字符为数字字符或者 '?' 。每一次操作中，如果 num 中至少有一个 '?' ，那么玩家可以执行以下操作：
 *
 * 选择一个下标 i 满足 num[i] == '?' 。
 * 将 num[i] 用 '0' 到 '9' 之间的一个数字字符替代。
 * 当 num 中没有 '?' 时，游戏结束。
 *
 * Bob 获胜的条件是 num 中前一半数字的和 等于 后一半数字的和。Alice 获胜的条件是前一半的和与后一半的和 不相等 。
 *
 * 比方说，游戏结束时 num = "243801" ，那么 Bob 获胜，因为 2+4+3 = 8+0+1 。如果游戏结束时 num = "243803" ，那么 Alice 获胜，因为 2+4+3 != 8+0+3 。
 * 在 Alice 和 Bob 都采取 最优 策略的前提下，如果 Alice 获胜，请返回 true ，如果 Bob 获胜，请返回 false 。
 */
public class SumGame {
    public boolean sumGame(String num) {
        int leftSum = 0, rightSum = 0;  // 左右数值总和
        int left = 0, right = 0;    //左右问号个数
        final int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (i < n / 2){
                if (c == '?'){
                    left++;
                }else {
                    leftSum += c - '0';
                }
            }else {
                if (c == '?'){
                    right++;
                }else {
                    rightSum += c - '0';
                }
            }
        }

        int sumDiff = leftSum - rightSum;   // 左右数值总和之差
        int numDiff = left - right;         // 左右问号个数之差

        if (sumDiff == 0 && numDiff == 0){
            // 左右数值总和之差 = 0, 左右问号个数之差 = 0, bob直接获胜
            return false;
        }else if (sumDiff == 0 || numDiff == 0){
            // 左右数值总和之差 与 左右问号个数之差 有一个 != 0, Alice 总是能破坏平衡，Alice 获胜
            return true;
        }else if (sumDiff * numDiff > 0){
            // 1. 左边数值总和高 并且 问号较多 2. 右边数值总和高 并且 右号较多
            // 这两种情况下 无论如何无法平衡，Alice 获胜
            return true;
        }else if (Math.abs(numDiff) % 2 == 1){
            // 问号个数是奇数，最后的问号总是Alice修改， Alice 总是能破坏平衡，Alice 获胜
            return true;
        }

        // 能走到这里只有两种种情况： 1. 左边数值总和高 并且 右边问号多偶数个 2. 右边数值总和高 并且 左边问号多偶数个. 两种情况是类似的，用情况1举例
        // 数值总和的差 = 9 并且 右边问号多2个 是一个特殊情况。 Alice先手无论选择哪个数字，Bob后手都能选择0-9的某个数字使其和=9
        // 类似的情况也发生在数值总和的差 = 9的倍数的时候
        return Math.abs(sumDiff) != Math.abs(numDiff / 2 * 9);

    }

    public static void main(String[] args) {
        SumGame sumGame = new SumGame();
        System.out.println(sumGame.sumGame("?3295???"));
    }
}
