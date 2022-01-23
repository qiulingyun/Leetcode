package QLY.Leetcode.binarySearch;

public class Search2DMatrix_2 {

	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int left = 0, right = matrix.length - 1, mid = 0;
        while(left <= right){
        	mid = (left + right)/2;
        	if (matrix[mid][0] == target) {
				return true;
			}else if (matrix[mid][0] < target) {
				left = mid + 1;
			}else{
				right = mid - 1;
			}
        }
        int mMax = mid;
        
        left = 0;
        right = matrix.length - 1;
        int lastElementPosi = matrix[0].length - 1;
        while(left <= right){
        	mid = (left + right)/2;
        	if (matrix[mid][lastElementPosi] == target) {
				return true;
			}else if (matrix[mid][lastElementPosi] < target) {
				left = mid + 1;
			}else{
				right = mid - 1;
			}
        }
        int mMin = mid;
        
        for (int i = mMin; i <= mMax; i++) {
			int[] line = matrix[i];
			left = 0;
	        right = line.length - 1;
	        while(left <= right){
	        	mid = (left + right)/2;
	        	if (line[mid] == target) {
					return true;
				}else if (line[mid] < target) {
					left = mid + 1;
				}else{
					right = mid - 1;
				}
	        }
		}
        
		return false;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {// 0    1   2  3   4
		                    {1,   4,  7, 11, 15},//0
		                    {2,   5,  8, 12, 19},//1
		                    {3,   6,  9, 16, 22},//2
		                    {10, 13, 14, 17, 24},//3
		                    {18, 21, 23, 26, 30} //4
						 };
		Search2DMatrix_2 obj = new Search2DMatrix_2();
		System.out.println(obj.searchMatrix(matrix, 17));
		System.out.println(obj.searchMatrix(matrix, 20));
	}

}
