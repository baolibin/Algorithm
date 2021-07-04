package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/8. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose :28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class _0028_strStr {
	/**
	 * 解题思路：
	 * 子串逐一比较的解法最简单，将长度为 L 的滑动窗口沿着 haystack 字符串逐步移动，并将窗口内的子串与 needle 字符串相比较，
	 * 时间复杂度为 O((N - L)L)
	 * 显示上面这个方法是可以优化的。双指针方法虽然也是线性时间复杂度，不过它可以避免比较所有的子串，
	 * 因此最优情况下的时间复杂度为 O(N)，但最坏情况下的时间复杂度依然为 O((N - L)L)。
	 */
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0) return 0;
		int h = haystack.length();
		int n = needle.length();
		for (int i = 0; i <= h - n; i++) {
			for (int j = 0; j < n; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
				if (j == n - 1) {
					return i;
				}
			}
		}
		return -1;
	}
}
