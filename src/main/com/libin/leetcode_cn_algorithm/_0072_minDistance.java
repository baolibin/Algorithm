package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class _0072_minDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 当min(i,j)==0时候,即有一个串为空时候,dp[i][j]=max(i,j)
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        // 当min(i,j)==0时候,即有一个串为空时候,dp[i][j]=max(i,j)
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int d = 0;
                if (char1[i - 1] != char2[j - 1]) { // 判断word1第i个元素和word2第j个元素,是否相等
                    d = 1;
                }
                // 删除ai,插入bj,ai替换bj
                dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + d));
            }
        }
        return dp[len1][len2];
    }
}
