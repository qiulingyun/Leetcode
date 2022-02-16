package QLY.Leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/count-primes/
 * 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]){
                result++;
                if ((long)i * i < n){
                    for (int j = i * i; j < n; j+=i) {
                        isPrime[j] = false;
                    }
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.countPrimes(499979));
    }
}
