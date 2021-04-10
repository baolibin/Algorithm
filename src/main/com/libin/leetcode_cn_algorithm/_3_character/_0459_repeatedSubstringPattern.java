package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose :459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
public class _0459_repeatedSubstringPattern {
	/**
	 * 解法一：
	 * 解题思路：
	 * 创建一个新的字符串 str，它等于原来的字符串 S 再加上 S 自身，这样其实就包含了所有移动的字符串。
	 * 比如字符串：S = abab，那么 str = S + S = abababab
	 * <p>
	 * 可以直接判断 str 中去除首尾元素之后 bababa，是否包含自身元素。如果包含。则表明存在重复子串。
	 */
	public boolean repeatedSubstringPattern(String s) {
		String str = s + s;
		return str.substring(1, str.length() - 1).contains(s);
	}

	/**
	 * 超时
	 */
	public boolean repeatedSubstringPattern2(String s) {
		for (int i = 1; i < s.length(); i++) {
			int index = i % s.length();
			char[] chars = s.toCharArray();
			swap(chars, 0, chars.length - 1);
			swap(chars, 0, index - 1);
			swap(chars, index, chars.length - 1);
			if (String.valueOf(chars).equals(s)) {
				return true;
			}
		}
		return false;
	}

	void swap(char[] chars, int start, int end) {
		while (start < end) {
			char tmp = chars[start];
			chars[start] = chars[end];
			chars[end] = tmp;
			start++;
			end--;
		}
	}
}
