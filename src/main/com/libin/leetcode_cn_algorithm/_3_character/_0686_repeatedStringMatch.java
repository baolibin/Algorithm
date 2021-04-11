package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 686. 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * 示例 2：
 * 输入：a = "a", b = "aa"
 * 输出：2
 * 示例 3：
 * 输入：a = "a", b = "a"
 * 输出：1
 * 示例 4：
 * 输入：a = "abc", b = "wxyz"
 * 输出：-1
 */
public class _0686_repeatedStringMatch {
	public int repeatedStringMatch(String a, String b) {
		int count = 1;
		if (a.contains(b))
			return count;
		int len = b.length() / a.length() + 1; // 如果b长度小于a长度，则a可以叠加一次
		StringBuilder sb = new StringBuilder();
		sb.append(a);
		for (int i = 0; i < len; i++) {
			sb.append(a);
			if (sb.toString().contains(b)) {
				return ++count;
			}
			count++;
		}
		return -1;
	}
}
