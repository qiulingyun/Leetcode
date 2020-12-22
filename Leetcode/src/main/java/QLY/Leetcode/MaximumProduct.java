package QLY.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 628. 三个数的最大乘积
 * 难度 简单
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        HashSet<Integer> index = new HashSet<>();
        List<Integer> big3 = new ArrayList<>();
        List<Integer> small2 = new ArrayList<>();

        for (int j = 3; j >= 0; j--){
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++){
                if (index.contains(i))
                    continue;
                if (nums[i] > max){
                    max = nums[i];
                    maxIndex = i;
                }

            }
            big3.add(max);
            index.add(maxIndex);
        }

        index = new HashSet<>();
        for (int j = 2; j >= 0; j--){
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < nums.length; i++){
                if (index.contains(i))
                    continue;
                if (nums[i] < min){
                    min = nums[i];
                    minIndex = i;
                }
            }
            small2.add(min);
            index.add(minIndex);
        }

        int i = big3.get(0) * big3.get(1) * big3.get(2);
        int j = big3.get(0) * small2.get(0) * small2.get(1);
        if (i > j)
            return i;
        return j;

    }

    public static void main(String[] args) {
        MaximumProduct maximumProduct = new MaximumProduct();
        System.out.println(maximumProduct.maximumProduct(new int[]{1,2,-3,-4}));
    }
}
