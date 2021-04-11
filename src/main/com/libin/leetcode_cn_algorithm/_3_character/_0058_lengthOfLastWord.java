package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * 输入：s = " "
 * 输出：0
 */
public class _0058_lengthOfLastWord {
	public int lengthOfLastWord(String s) {
		String[] str = s.trim().split("\\s++");
		return str.length == 0 ? 0 : str[str.length - 1].length();
	}
}
