package QLY.Leetcode.array;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 378. 有序矩阵中第 K 小的元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n-1][n-1];
        while (left <= right){
            int mid = left + (right - left) / 2;
            int count = find(matrix, mid);
            if (count >= k){
                right = mid - 1;
            }else if (count < k){
                left = mid + 1;
            }
        }

        return left;
    }

    private int find(int[][] matrix, int target){
        int n = matrix.length;
        int[] curr = {n - 1, 0};
        int count = 0;
        while (curr[0] >= 0 && curr[0] < n && curr[1] >= 0 && curr[1] < n){
            int x = matrix[curr[0]][curr[1]];
            if (x <= target){
                curr[1]++;
                count += curr[0] + 1;
            }else if (x > target){
                curr[0]--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix kth = new KthSmallestElementInASortedMatrix();
        int[][] matrix = new int[][]
                {{1,5,9},
                 {10,11,13},
                 {12,13,15}};
        System.out.println(kth.kthSmallest(matrix, 4));
        //矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
    }

}
