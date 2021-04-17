package libin.leetcode_cn_algorithm._1_array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Copyright (c) 2021/4/17. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class _0350_intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums2) {
			Integer count = map.getOrDefault(num, 0);
			map.put(num, count + 1);
		}
		int cur = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])) {
				Integer count = map.get(nums1[i]);
				if (count <= 1) {
					map.remove(nums1[i]);
				} else {
					map.put(nums1[i], --count);
				}
				nums1[cur++] = nums1[i];
			}
		}
		return Arrays.copyOfRange(nums1, 0, cur);
	}
}
