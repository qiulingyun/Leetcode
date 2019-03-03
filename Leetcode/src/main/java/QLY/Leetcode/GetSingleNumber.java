package QLY.Leetcode;

import java.util.HashSet;

public class GetSingleNumber {

	public int singleNumber(int[] nums) {
		HashSet<Integer> numberSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	if (numberSet.contains(nums[i])) {
				numberSet.remove(nums[i]);
			}else{
				numberSet.add(nums[i]);
			}
        }
        return numberSet.iterator().next();
    }
	
	public int singleNumberCorrect(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0, 0, 2, 1, 2};
		GetSingleNumber obj = new GetSingleNumber();
		int result;
		result = obj.singleNumber(input);
		System.out.println(result);
		result = obj.singleNumberCorrect(input);
		System.out.println(result);		
	}

}
