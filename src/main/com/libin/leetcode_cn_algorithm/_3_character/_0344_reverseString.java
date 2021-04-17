package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/17. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class _0344_reverseString {
	public void reverseString(char[] s) {
		int low = 0, high = s.length - 1;
		while (low < high) {
			char swap = s[low];
			s[low++] = s[high];
			s[high--] = swap;
		}
	}
}
