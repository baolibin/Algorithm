package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/14. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 */
public class _0389_findTheDifference {
	/**
	 * 方法一：计数
	 */
	public char findTheDifference(String s, String t) {
		int[] cnt = new int[256];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			int index = t.charAt(i) - 'a';
			cnt[index]--;
			if (cnt[index] < 0) {
				return t.charAt(i);
			}
		}
		return ' ';
	}

	/**
	 * 方法二：求和
	 */
	public char findTheDifference2(String s, String t) {
		int cntS = 0, conT = 0;
		for (int i = 0; i < s.length(); i++) {
			cntS += s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			conT += t.charAt(i);
		}
		return (char) (conT - cntS);
	}

	/**
	 * 方法三：位运算
	 */
	public char findTheDifference3(String s, String t) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			res ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			res ^= t.charAt(i);
		}
		return (char) res;
	}
}
