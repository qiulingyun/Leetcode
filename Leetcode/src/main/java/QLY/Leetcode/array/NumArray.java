package QLY.Leetcode.array;

/**
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 * 307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 *
 * 实现 NumArray 类：
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值更新为 val
 * int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）
 */
public class NumArray {
    int[] bit;
    int[] origin;

    public NumArray(int[] nums) {
        this.origin = nums;
        bit = new int[nums.length + 1];
        for (int i = 1; i < bit.length; i++) {
            for (int j = i; j < bit.length; j+=lowbit(j)) {
                bit[j] += nums[i - 1];
            }

        }
    }

    public void update(int index, int val) {
        int delta = val - this.origin[index];
        for (int i = index; i < bit.length; i+=lowbit(i)) {
            bit[i] += delta;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return sum(right);
        return sum(right) - sum(left - 1);
    }

    private static int lowbit(int x){
        return x & (-x);
    }

    private int sum(int end){
        int sum = 0;
        for (int i = end + 1; i > 0; i-=lowbit(i)) {
            sum += bit[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
