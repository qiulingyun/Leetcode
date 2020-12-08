package QLY.Leetcode.dp;

public class FindMaxForm {
//    public int findMaxForm(String[] strs, int m, int n) {
//        int len = strs.length;
//        if(len == 0) return 0;
//
//        int[][] dp = new int[m+1][n+1];
//        for (String str : strs) {
//            int num0 = getZeroNumber(str);
//            int num1 = str.length() - num0;
//
//
//            for (int i = m; i >= num0; i--) {
//                for (int j = n; j >= num1; j--) {
//                    dp[i][j] = Math.max(dp[i][j],dp[i-num0][j-num1]+1);
//                }
//            }
//        }
//        return dp[m][n];
//    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String s: strs){
            int num0 = getZeroNumber(s);
            int num1 = s.length() - num0;
            for (int i = m; i >= num0; i--){
                for (int j = n; j >= num1; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-num0][j-num1]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int getZeroNumber(String str){
        int count = 0;
        for (char c: str.toCharArray()){
            if (c == '0'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        System.out.println(findMaxForm.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
