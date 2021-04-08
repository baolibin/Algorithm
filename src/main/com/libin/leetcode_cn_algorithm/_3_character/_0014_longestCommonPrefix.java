package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/8. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose :14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class _0014_longestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {  // 循环遍历之后的每一个元素
			while (strs[i].indexOf(prefix) != 0) {  // 查找元素i之前所有元素的公共前缀
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.length() == 0) {
					return "";
				}
			}
		}
		return prefix;
	}
}
