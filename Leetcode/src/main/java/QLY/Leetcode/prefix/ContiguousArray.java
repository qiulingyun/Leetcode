package QLY.Leetcode.prefix;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/contiguous-array/
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * good answer: https://leetcode-cn.com/problems/contiguous-array/solution/dong-tu-yan-shi-qian-zhui-he-si-xiang-by-z2no/
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        final int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0, -1);}};
        int curr = 0;

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                curr++;
            else
                curr--;

            if (map.containsKey(curr)){
                result = Math.max(result, i - map.get(curr));
            }else {
                map.put(curr, i);
            }
        }

        return result;
    }
}
