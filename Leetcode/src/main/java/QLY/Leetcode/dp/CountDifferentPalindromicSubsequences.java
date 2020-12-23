package QLY.Leetcode.dp;

/**
 * https://leetcode-cn.com/problems/count-different-palindromic-subsequences/
 * 730. 统计不同回文子序列
 * 难度 困难
 * 给定一个字符串 S，找出 S 中不同的非空回文子序列个数，并返回该数字与 10^9 + 7 的模。
 * 通过从 S 中删除 0 个或多个字符来获得子序列。
 * 如果一个字符序列与它反转后的字符序列一致，那么它是回文字符序列。
 * 如果对于某个  i，A_i != B_i，那么 A_1, A_2, ... 和 B_1, B_2, ... 这两个字符序列是不同的。
 *
 * 示例 1：
 * 输入：
 * S = 'bccb'
 * 输出：6
 * 解释：
 * 6 个不同的非空回文子字符序列分别为：'b', 'c', 'bb', 'cc', 'bcb', 'bccb'。
 * 注意：'bcb' 虽然出现两次但仅计数一次。
 * 示例 2：
 * 输入：
 * S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 * 输出：104860361
 * 解释：
 * 共有 3104860382 个不同的非空回文子序列，对 10^9 + 7 取模为 104860361。
 *
 * 提示：
 * 字符串 S 的长度将在[1, 1000]范围内。
 * 每个字符 S[i] 将会是集合 {'a', 'b', 'c', 'd'} 中的某一个。
 */
public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String S) {
        // [i..j]的回文子序列的个数
        long[][] dp = new long[S.length()][S.length()];
        for (int i = 0; i < S.length(); i++){
            dp[i][i] = 1;
        }
        long M = (long) (Math.pow(10, 9) + 7);
        for (int i = S.length() - 2; i >= 0; i--){
            for (int j = i + 1; j < S.length(); j++){
                if (S.charAt(i) == S.charAt(j)){
                    //left用于寻找与S[i]相同的左端第一个下标，right用于寻找与S[i]相同的右端第一个下标
                    int left = i + 1, right = j - 1;
                    while (left <= right && S.charAt(left) != S.charAt(i)) {
                        ++left;
                    }
                    while (left <= right && S.charAt(right) != S.charAt(i)) {
                        --right;
                    }
                    if (left > right) {
                        //中间没有和S[i]相同的字母，例如"aba"这种情况
                        //其中dp[i + 1][j - 1]是中间部分的回文子序列个数，因为中间的所有子序列可以单独存在，也可以再外面包裹上字母a，所以是成对出现的，要乘2。
                        //加2是统计外层的"a"和"aa"
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    }
                    else if (left == right) {
                        //中间只有一个和S[i]相同的字母，就是"aaa"这种情况，
                        //其中乘2的部分跟上面的原因相同，
                        //加1的原因是单个字母"a"的情况已经在中间部分算过了，外层就只能再加上个"aa"了。
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    }
                    else {
                        //中间至少有两个和S[i]相同的字母，就是"aabaa"这种情况，
                        //其中乘2的部分跟上面的原因相同，要减去left和right中间部分的子序列个数的原因是其被计算了两遍，要将多余的减掉。
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }

                }else {
                    //dp[i][j - 1] + dp[i + 1][j]这里计算了dp[i + 1][j - 1]两遍
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];

                }

                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + M : dp[i][j] % M;
            }
        }
        return (int)dp[0][S.length()-1];
    }

    public static void main(String[] args) {
        CountDifferentPalindromicSubsequences countDifferentPalindromicSubsequences = new CountDifferentPalindromicSubsequences();
        System.out.println(countDifferentPalindromicSubsequences.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }
}
