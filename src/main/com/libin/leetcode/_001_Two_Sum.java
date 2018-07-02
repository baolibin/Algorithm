package libin.leetcode;

import java.util.HashMap;

/**
1、Two Sum问题：
题目地址：https://leetcode.com/problems/two-sum/
题目：
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class _001_Two_Sum {

	public static void main(String[] args) {
		int[] nums ={2, 7, 11, 15, 16};
		Solution5 solution = new Solution5();
		int[] result =new Solution1().twoSum(nums, 18);
		System.out.println("["+result[0]+","+result[1]+"]");
	}

}
/**
 * Time complexity : O(n)O(n)
 * Space complexity : O(n)O(n)
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
    	int[] res={0,0};
    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if(hashMap.containsKey(target-nums[i])){
				res[0]=hashMap.get(target-nums[i]);
				res[1]=i;
				break;
			}
			hashMap.put(nums[i], i);
		}
		return res;
    }
}





