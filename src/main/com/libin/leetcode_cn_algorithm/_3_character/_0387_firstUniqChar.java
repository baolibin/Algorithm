package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose :387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 */
public class _0387_firstUniqChar {
	/**
	 * 解题思路：
	 * 使用数组计数
	 */
	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			arr[chars[i] - 'a']++;
		}
		for (int i = 0; i < chars.length; i++) {
			if (arr[chars[i] - 'a'] == 1) {
				return i;
			}
		}
		return -1;
	}
}
