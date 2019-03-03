package QLY.Leetcode;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] answer = new int[nums1.length];
        int curr = 0;
        
        int i = 0, j = 0;
		while(i < m && j < n) {
			if (nums1[i] >= nums2[j]) {
				answer[curr++] = nums2[j++];
			}else{
				answer[curr++] = nums1[i++];
			}
		}
		if (i == m) {
			while(j < n){
				answer[curr++] = nums2[j++];
			}
		}
		if (j == n) {
			while(i < m){
				answer[curr++] = nums1[i++];
			}
		}
		
		for (int tmp = 0; tmp < answer.length; tmp++) {
			nums1[tmp] = answer[tmp];
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		int m = 3, n = 3;
		
		MergeSortedArray obj = new MergeSortedArray();
		obj.merge(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.print(i);
		}
		System.out.println();
	}

}
