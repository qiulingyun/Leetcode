package QLY.Leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/heaters/
 * 475. 供暖器
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        int max = 0;
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = binarySearch(heaters, houses[i]);

            if (index == heaters.length){
                min = houses[i] - heaters[index - 1];
            }else {
                if (heaters[index] == houses[i])
                    continue;

                if (index > 0){
                    min = Math.min(heaters[index] - houses[i], houses[i] - heaters[index - 1]);
                }else {
                    min = heaters[index] - houses[i];
                }
            }
            max = Math.max(max, min);
        }
        return max;
    }

    private int binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int findRadiusWithLoop(int[] houses, int[] heaters) {
        int max = 0;
        for (int house: houses) {
            int min = Integer.MAX_VALUE;
            for (int heater : heaters) {
                int dis = Math.abs(house - heater);
                min = Math.min(min, dis);
            }
            max = Math.max(max, min);
        }
        return max;
    }

    public static void main(String[] args) {
        Heaters heaters = new Heaters();
        System.out.println(heaters.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(heaters.findRadius(new int[]{1,5}, new int[]{2}));
    }
}
