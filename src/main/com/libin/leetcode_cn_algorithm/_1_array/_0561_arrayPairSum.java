package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 561. 数组拆分 I
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 * 示例 1：
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 * 示例 2：
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
 */
public class _0561_arrayPairSum {
	public int arrayPairSum(int[] nums) {
		sortScheduler(nums, 0, nums.length - 1);
		int res = 0;
		for (int i = 0; i < nums.length; i += 2) {
			res += nums[i];
		}
		return res;
	}

	void sortScheduler(int[] nums, int low, int high) {
		if (low < high) {
			int mid = quickSort(nums, low, high);
			sortScheduler(nums, low, mid - 1);
			sortScheduler(nums, mid + 1, high);
		}
	}

	int quickSort(int[] nums, int low, int high) {
		int base = nums[low];
		while (low < high) {
			while (low < high && nums[high] >= base) {
				high--;
			}
			nums[low] = nums[high];
			while (low < high && nums[low] <= base) {
				low++;
			}
			nums[high] = nums[low];
		}
		nums[low] = base;
		return low;
	}

}
