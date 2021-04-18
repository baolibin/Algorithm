package libin.leetcode_cn_algorithm._6_number;

/**
 * Copyright (c) 2021/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 461. 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class _0461_hammingDistance {
	/**
	 * 当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除。
	 */
	public int hammingDistance(int x, int y) {
		int res = x ^ y;
		int count = 0;
		while (res != 0) {
			count++;
			res = res & (res - 1);
		}
		return count;
	}
}
