package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/10. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1:
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000
 */
public class _0680_validPalindrome {
	public boolean validPalindrome(String s) {
		int low = 0, high = s.length() - 1;
		while (low < high) {
			if (s.charAt(low) == s.charAt(high)) {
				low++;
				high--;
			} else {
				return validPalindrome(s, low + 1, high) || validPalindrome(s, low, high - 1);
			}
		}
		return true;
	}

	boolean validPalindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low) != s.charAt(high)) {
				return false;
			}
			low++;
			high--;
		}
		return true;
	}
}
