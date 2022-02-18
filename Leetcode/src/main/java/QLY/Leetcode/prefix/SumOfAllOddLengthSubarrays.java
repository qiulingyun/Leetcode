package QLY.Leetcode.prefix;

public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        final int n = arr.length;
        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= i + 1; j+=2) {
                if (j == i + 1){
                    result += pre[i];
                }else {
                    result += pre[i] - pre[i - j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SumOfAllOddLengthSubarrays sum = new SumOfAllOddLengthSubarrays();
        System.out.println(sum.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
    }
}
