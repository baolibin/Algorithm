package libin.leetcode_cn_algorithm._3_character;

/**
 * Copyright (c) 2021/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 */
public class _0005_longestPalindrome {
	/**
	 * 动态规划的状态转移方程：P(i,j)=P(i+1,j−1)∧(Si ==Sj)
	 */
	public String longestPalindrome(String s) {
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		String res = "";
		for (int l = 0; l < len; l++) {
			for (int i = 0; i + l < len; i++) {
				int j = i + l; //定位到子串l的结尾位置
				if (l == 0) { // 字符串长度为1
					dp[i][j] = true;
				} else if (l == 1) { // 字符串长度为2
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else { // 字符串长度多于2
					dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]);
				}
				if (dp[i][j] && 1 + l > res.length()) {
					res = s.substring(i, i + l + 1);
				}
			}
		}
		return res;
	}

	/**
	 * 解法2：
	 * 字符串反转，和原串求最长公共子串
	 */
	String longestPalindrome2(String s) {
		if (s.length() <= 1) {
			return s;
		}
		int len = s.length();
		String reverse = new StringBuilder(s).reverse().toString();
		int[][] dp = new int[len][len];
		int maxLen = 0;
		int maxEnd = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (s.charAt(i) == reverse.charAt(j)) {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
				}
				if (dp[i][j] > maxLen) {
					// 需要排除掉非回文串情况。比如"aacabdkacaa"
					int beforeRev = len - j - 1;
					if (beforeRev + dp[i][j] - 1 == i) {
						maxLen = dp[i][j];
						maxEnd = i;
					}
				}
			}
		}
		return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
	}
}
