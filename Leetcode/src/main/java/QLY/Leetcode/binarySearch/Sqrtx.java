package QLY.Leetcode.binarySearch;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * 69. Sqrt(x)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Sqrtx {
    public int mySqrt(int x) {
        if (x == 1)
            return 1;
        int left = 1, right = x;
        while (left < right){
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left - 1;
    }

    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        System.out.println(sqrtx.mySqrt(2147395599));
    }
}
