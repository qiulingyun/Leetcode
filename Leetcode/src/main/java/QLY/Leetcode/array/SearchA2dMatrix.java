package QLY.Leetcode.array;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 */
public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firsts = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firsts[i] = matrix[i][0];
        }
        int x = binarySearch(firsts, target);
        if (x < 0)
            return false;
        int y = binarySearch(matrix[x], target);
        if (matrix[x][y] == target)
            return true;

        return false;
    }

    public int binarySearch(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid] )
                left = mid + 1;
            else
                right = mid;
        }
        return left - 1;
    }

    public static void main(String[] args) {
        SearchA2dMatrix obj = new SearchA2dMatrix();
//        System.out.println(obj.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
//        System.out.println(obj.searchMatrix(new int[][]{{1}}, 0));

        System.out.println(obj.binarySearch(new int[]{0, 1, 3}, 1));
        System.out.println(obj.binarySearch(new int[]{0, 1, 3}, 0));
        System.out.println(obj.binarySearch(new int[]{0, 1, 3}, 2));
        System.out.println(obj.binarySearch(new int[]{0, 1, 3}, 4));

    }
}
