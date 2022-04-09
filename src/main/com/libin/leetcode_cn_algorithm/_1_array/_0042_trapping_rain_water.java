package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2022/4/9. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 解法：
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode-solution-tuvc/
 */
public class _0042_trapping_rain_water {
	public int trap(int[] height) {
		int len = height.length;
		if (len == 0) {
			return 0;
		}
		// 存放每个元素左边所有元素的最高位置
		int[] leftMax = new int[len];
		leftMax[0] = height[0];
		for (int i = 1; i < len; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], height[i]);
		}
		// 存放每个元素右边所有元素的最高位置
		int[] rightMax = new int[len];
		rightMax[len - 1] = height[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], height[i]);
		}
		// 存储所有元素接雨水累加值
		int res = 0;
		for (int i = 0; i < len; i++) {
			res += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		return res;
	}
}
