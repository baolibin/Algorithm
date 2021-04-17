package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/17. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class _0415_addStrings {
	public String addStrings(String num1, String num2) {
		int len1 = num1.length() - 1, len2 = num2.length() - 1;
		int i = len1, j = len2, add = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int res = x + y + add;
			int mod = res % 10;
			sb.append(mod);
			add = res / 10;
			i--;
			j--;
		}
		return sb.reverse().toString();
	}
}
