package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */
public class _0172_trailingZeroes {
	/**
	 * 解题思路：
	 * 含有 2 的因子每两个出现一次，含有 5 的因子每 5 个出现一次，所有 2 出现的个数远远多于 5，
	 * 换言之找到一个 5，一定能找到一个 2 与之配对。所以我们只需要找有多少个 5。
	 * 直接的，我们只需要判断每个累乘的数有多少个 5 的因子即可。
	 */
	public int trailingZeroes(int n) {
		int count5 = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num > 0) {
				if (num % 5 == 0) {
					count5++;
					num /= 5;
				} else {
					break;
				}
			}
		}
		return count5;
	}
}
