package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class _0557_reverseWords {
	public String reverseWords(String s) {
		char[] chars = s.toCharArray();
		int len = chars.length;
		int low = 0, high = 0, cur = 0, curHigh = 0;
		while (cur <= len) {
			if (cur == len || chars[cur] == ' ') {
				high = cur + 1;
				curHigh = cur - 1;
				while (low < curHigh) {
					char swap = chars[low];
					chars[low++] = chars[curHigh];
					chars[curHigh--] = swap;
				}
				low = high;
				cur = high;
			}
			cur++;
		}
		return String.valueOf(chars);
	}
}
