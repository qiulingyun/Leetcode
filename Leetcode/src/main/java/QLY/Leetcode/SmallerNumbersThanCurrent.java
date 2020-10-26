package QLY.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[][] data = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++){
            data[i][0] = nums[i];
            data[i][1] = i;
        }

        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));

        int[] ans = new int[nums.length];
        int prev = 0;
        for (int i = 1; i < data.length; i++){
            if (data[i][0] != data[prev][0]){
               prev = i;
            }
            ans[data[i][1]] = prev;
        }
        return ans;
    }
    public static void main(String[] args) {
        SmallerNumbersThanCurrent SmallerNumbersThanCurrent = new SmallerNumbersThanCurrent();
        System.out.println(SmallerNumbersThanCurrent.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}).toString());
    }
}
