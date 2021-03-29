package libin.leetcode_cn_algorithm._1_array;

import java.util.HashMap;

/**
 * Copyright (c) 2021/3/28. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 和为K的子数组(非正整数数组)
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class _0560_subarraySum {
    // 前缀和
	int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		// 对于下标为0的元素，前缀和为0，元素为1
		map.put(0, 1);
		int preSum = 0;
		int count = 0;
		for (int num : nums) {
			preSum += num;
			if (map.containsKey(preSum - k)) {
				count += map.get(preSum - k);
			}
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}
		return count;
	}
}
