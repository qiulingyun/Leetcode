package QLY.Leetcode.tree;

import java.util.HashSet;

/***
 * 1306. 跳跃游戏 III
 * 难度
 * 中等

 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 * 示例 1：
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 */
public class CanJump3 {
    HashSet<Integer> visited = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0){
            return true;
        }

        int left = start - arr[start];
        int right = start + arr[start];

        boolean leftCanReach = false, rightCanReach = false;
        if (left >= 0 && left < arr.length && !visited.contains(left)){
            visited.add(left);
            leftCanReach = canReach(arr, left);
        }
        if (right >= 0 && right < arr.length && !visited.contains(right)){
            visited.add(right);
            rightCanReach = canReach(arr, right);
        }

        return leftCanReach || rightCanReach;
    }

    public static void main(String[] args) {
        CanJump3 canJump3 = new CanJump3();
        System.out.println(canJump3.canReach(new int[]{4,2,3,0,3,1,2}, 5));
    }
}
