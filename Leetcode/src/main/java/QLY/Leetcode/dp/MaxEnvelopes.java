package QLY.Leetcode.dp;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 * 难度 困难
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 说明:
 * 不允许旋转信封。
 * 示例:
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes,(a,b)->{
            if (a[0] == b[0])
                return b[1] - a[1];
            return b[0] - a[0];
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i <  envelopes.length; i++){
            for (int j = 0; j < i; j++){
                if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int m = 0;
        for (int l: dp){
            m = Math.max(m, l);
        }
        return m;
    }

    public static void main(String[] args) {
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        System.out.println(maxEnvelopes.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
}
