package libin.leetcode_cn_algorithm._3_character;

import java.util.HashMap;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose :383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class _0383_canConstruct {
	/**
	 * 解题思路：
	 * 1、利用哈希表，存储赎金信需要的字符数量
	 * 2、然后遍历杂志字符串，在哈希表中把需要的数量减一
	 * 3、最后遍历哈希表，如果有字符还没减到0，说明不能满足，返回false
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] patternChars = magazine.toCharArray();
		for (char patternChar : patternChars) {
			int count = map.getOrDefault(patternChar, 0);
			map.put(patternChar, count + 1);
		}
		char[] matchChars = ransomNote.toCharArray();
		for (char matchChar : matchChars) {
			int count = map.getOrDefault(matchChar, 0);
			if (count == 0) return false;
			map.put(matchChar, count - 1);
		}
		return true;
	}

	/**
	 * 解法2：
	 */
	public boolean canConstruct2(String ransomNote, String magazine) {
		int[] cnt = new int[26];
		for (char c : magazine.toCharArray()) {
			cnt[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			cnt[c - 'a']--;
			if (cnt[c - 'a'] < 0) return false;
		}
		return true;
	}
}
