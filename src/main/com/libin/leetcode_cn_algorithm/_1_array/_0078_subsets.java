package libin.leetcode_cn_algorithm._1_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2021/3/27. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose :
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class _0078_subsets {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> curList = new ArrayList<Integer>();

	public List<List<Integer>> subsets(int[] nums) {
		subsetNums(0, nums);
		return res;
	}

	/**
	 * 时间复杂度：O(n * 2 ^ n)。一共 2^n 个状态，每种状态需要 O(n) 的时间来构造子集。
	 * 空间复杂度：O(n)。临时数组 t 的空间代价是 O(n)，递归时栈空间的代价为 O(n)。
	 */
	public void subsetNums(int curIndex, int[] nums) {
		if (curIndex == nums.length) {
			res.add(new ArrayList<>(curList));
			return;
		}
		// 子集包括 下标为curIndex 的元素
		curList.add(nums[curIndex]);
		subsetNums(curIndex + 1, nums);
		// 子集不包括 下标为curIndex 的元素
		curList.remove(curList.size() - 1);
		subsetNums(curIndex + 1, nums);
	}

}
