package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose :541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 提示：
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 */
public class _0541_reverseStr {
	/**
	 * 暴力解法：
	 * 直接翻转每个 2k 字符块。
	 */
	public String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i += 2 * k) {
			int end = Math.min(i + k - 1, chars.length - 1);
			int start = i;
			while (start < end) {
				char tmp = chars[start];
				chars[start++] = chars[end];
				chars[end--] = tmp;
			}
		}
		return String.valueOf(chars);
	}
}
