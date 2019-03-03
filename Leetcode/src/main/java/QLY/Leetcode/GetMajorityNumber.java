package QLY.Leetcode;

import java.util.HashMap;

public class GetMajorityNumber {

	public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer a = map.get(nums[i]);
			if (a == null) {
				a = new Integer(0);
			}
			map.put(nums[i], a + 1);
			if (a + 1 > nums.length / 2) {
				return nums[i];
			}
		}
		return -1;
    }
	
	public int majorityElementCorrect(int[] nums){
		//摩尔投票法
		int result = -1, counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if (counter == 0) {
				result = nums[i];
				counter = 1;
			}else if (result == nums[i]) {
				counter++;
			}else if (result != nums[i]) {
				counter--;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 1, 1, 2, 3, 4, 1};
		GetMajorityNumber obj = new GetMajorityNumber();
		int result = obj.majorityElement(input);
		System.out.println(result);
		result = obj.majorityElementCorrect(input);
		System.out.println(result);
	}

}
