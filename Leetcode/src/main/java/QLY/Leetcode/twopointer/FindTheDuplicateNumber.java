package QLY.Leetcode.twopointer;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // 1, 3, 4, 2, 2
        // 1  2  3  4  5
        /**
         * 1->1
         * 2->3
         * 3->4
         * 4->2
         * 5->2
         * 2->3->4->2
          */

        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;


    }

    public static void main(String[] args) {
        FindTheDuplicateNumber f = new FindTheDuplicateNumber();
        System.out.println(f.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
