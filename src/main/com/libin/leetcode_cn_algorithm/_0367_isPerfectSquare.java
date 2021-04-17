package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2021/4/14. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 */
public class _0367_isPerfectSquare {
	/**
	 * 解题思路： 二分查找
	 */
	public boolean isPerfectSquare(int num) {

		long low = 0;
		// int high = Math.min(num, 46340);
		long high = Math.min(num, 1 << 16);
		while (low <= high) {
			long middle = low + (high - low) / 2;
			long square = middle * middle;
			System.out.println("square=" + square);
			if (square == num) {
				return true;
			} else if (square < num) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}
