package QLY.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> results = new HashSet<>();
        for (int i: nums1){
            if (results.contains(i)){
                continue;
            }
            for (int j: nums2) {
                if (i == j){
                    results.add(j);
                    break;
                }
            }
        }
        Integer[] a = new Integer[results.size()];
        results.toArray(a);
        int[] ret = new int[results.size()];
        for (int i = 0; i < a.length; i++){
            ret[i] = a[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        Intersection Intersection = new Intersection();
        System.out.println(Arrays.toString(Intersection.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));

    }
}
