package libin.leetcode_cn_algorithm._1_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class _0448_findDisappearedNumbers {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0, len = nums.length;
		while (index < len) {
			if (index + 1 == nums[index] || nums[index] == nums[nums[index] - 1]) {
				index++;
			} else {
				int lowValue = nums[index];
				int highValue = nums[lowValue - 1];
				nums[index] = highValue;
				nums[lowValue - 1] = lowValue;
			}
		}
		for (int i = 0; i < len; i++) {
			if (i + 1 != nums[i]) {
				list.add(i + 1);
			}
		}
		return list;
	}
}
