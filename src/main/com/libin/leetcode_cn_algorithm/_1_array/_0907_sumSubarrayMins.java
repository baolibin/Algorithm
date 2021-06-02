package libin.leetcode_cn_algorithm._1_array;

import java.util.Arrays;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 907. 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * 示例 1：
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 */
public class _0907_sumSubarrayMins {
	/**
	 * 超出时间限制
	 */
	public int sumSubarrayMins(int[] arr) {
		double mod = Math.pow(10, 9) + 7;
		if (arr.length == 1)
			return arr[0];
		int len = arr.length;
		int[] flag = Arrays.copyOf(arr, arr.length);
		for (int i = 1; i < len; i++) {
			int tmpSum = 0;
			int minFlag = arr[i];
			for (int j = i; j >= 0; j--) {
				minFlag = Math.min(minFlag, arr[j]);
				tmpSum += minFlag;
			}
			flag[i] = (int) ((int) (flag[i - 1] + tmpSum) % mod);
		}
		return flag[len - 1];
	}
}
