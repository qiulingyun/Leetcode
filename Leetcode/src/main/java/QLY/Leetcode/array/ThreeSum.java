package QLY.Leetcode.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    // use array+Hash is too complicated, use two pointer
//    public List threeSum(int[] nums) {
//        if (nums.length < 3)
//            return new ArrayList<>();
//
//
//        HashMap<Integer, HashSet<Integer>> indexMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            HashSet<Integer> set = indexMap.getOrDefault(nums[i], new HashSet<>());
//            set.add(i);
//            indexMap.putIfAbsent(nums[i], set);
//        }
//
//        List<Set<Integer>> dup = new ArrayList<>();
//        List<List<Integer>> results = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = i + 1; j < nums.length; j++) {
//
//                if (indexMap.containsKey((-1)*nums[i] - nums[j])){
//                    HashSet<Integer> indexSet = indexMap.get((-1)*nums[i] - nums[j]);
//                    if (indexSet.contains(i) || indexSet.contains(j))
//                        continue;
//
//                    Set<Integer> ans = new HashSet<>();
//                    ans.add(nums[i]);
//                    ans.add(nums[j]);
//                    ans.add((-1)*nums[i] - nums[j]);
//                    boolean existed = false;
//
//
//                    for (Set<Integer> set : dup) {
//                        if (set.equals(ans)) {
//                            existed = true;
//                            break;
//                        }
//                    }
//                    if (!existed){
//                        dup.add(ans);
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add((-1)*nums[i] - nums[j]);
//                        results.add(list);
//                    }
//
//                }
//            }
//        }
//
//        return results;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return new ArrayList<>();

        Arrays.sort(nums);

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int j = i + 1, k = nums.length - 1;
            while (j < k){
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    results.add(list);
                    do {
                        j++;
                    }while (j < nums.length && nums[j] == nums[j - 1]);
                    do {
                        k--;
                    }while (k > 0 && nums[k] == nums[k + 1]);
                }else if (nums[i] + nums[j] + nums[k] > 0){
                    do {
                        k--;
                    }while (k > 0 && nums[k] == nums[k + 1]);
                }else {
                    do {
                        j++;
                    }while (j < nums.length && nums[j] == nums[j - 1]);
                }
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-2,0,1,1,2}));
//        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(threeSum.threeSum(new int[]{0,0,0}));
    }
}
