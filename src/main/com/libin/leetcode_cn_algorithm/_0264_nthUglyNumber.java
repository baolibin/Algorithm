package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 */
public class _0264_nthUglyNumber {
	public int nthUglyNumber(int n) {
		if (n <= 0) {
			return 0;
		}
		int[] result = new int[n];
		result[0] = 1; //第一个丑数为1
		int currentIndex = 1;
		int cur2 = 0, cur3 = 0, cur5 = 0;
		while (currentIndex < n) {
			int min = getMin(result[cur2] * 2, result[cur3] * 3, result[cur5] * 5);
			result[currentIndex] = min;
			while (result[cur2] * 2 <= min) {
				cur2++;
			}
			while (result[cur3] * 3 <= min) {
				cur3++;
			}
			while (result[cur5] * 5 <= min) {
				cur5++;
			}
			currentIndex++;
		}
		return result[currentIndex - 1];
	}

	public int getMin(int num2, int num3, int num5) {
		return Math.min(Math.min(num2, num3), num5);
	}
}
