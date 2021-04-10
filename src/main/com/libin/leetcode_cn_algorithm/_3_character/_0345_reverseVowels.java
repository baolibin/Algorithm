package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * Purpose :345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1：
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * 输入："leetcode"
 * 输出："leotcede"
 */
public class _0345_reverseVowels {
	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		int start = 0;
		int end = chars.length - 1;
		while (start < end) {
			while (start < end && !judge(chars[start])) {
				start++;
			}
			while (end > start && !judge(chars[end])) {
				end--;
			}
			char tmp = chars[start];
			chars[start++] = chars[end];
			chars[end--] = tmp;
		}
		return String.valueOf(chars);
	}

	boolean judge(char chars) {
		if (chars == 'A' || chars == 'E' || chars == 'I' || chars == 'O' || chars == 'U'
				|| chars == 'a' || chars == 'e' || chars == 'i' || chars == 'o' || chars == 'u') {
			return true;
		} else {
			return false;
		}
	}

}
