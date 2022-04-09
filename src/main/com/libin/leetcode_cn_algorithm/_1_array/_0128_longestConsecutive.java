package libin.leetcode_cn_algorithm._1_array;

import java.util.HashSet;

/**
 * Copyright (c) 2021/3/27. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数组连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class _0128_longestConsecutive {
	public int longestConsecutive(int[] nums) {
		int maxLen = 0;
		HashSet<Integer> hashSet = new HashSet<>();
		for (int number : nums) {
			hashSet.add(number);
		}
		for (Integer number : hashSet) {
			if (!hashSet.contains(number - 1)) {
				int curNum = number;
				int curLen = 1;
				while (hashSet.contains(curNum + 1)) {
					curNum++;
					curLen++;
				}
				maxLen = Math.max(maxLen, curLen);
			}
		}
		return maxLen;
	}
}
