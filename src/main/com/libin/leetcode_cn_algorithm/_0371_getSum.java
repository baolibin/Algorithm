package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2021/4/17. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose :
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class _0371_getSum {
	/**
	 * 基本思路： 位运算
	 * 第一步：相加各位的值，不算进位
	 * 第二步：计算进位值
	 * 第三步：进位不为0，计算相加
	 */
	public int getSum(int a, int b) {
		while (b != 0) {
			int sum = a ^ b; //相加和
			b = (a & b) << 1; //进位
			a = sum; //相加和
		}
		return a;
	}
}
