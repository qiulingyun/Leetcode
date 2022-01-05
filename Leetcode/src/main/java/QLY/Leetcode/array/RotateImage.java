package QLY.Leetcode.array;

public class RotateImage {
    // (x, y) => (y, length-1 - x) =>  (length-1 - x, length-1 - y) => (length-1 - y, x)
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
