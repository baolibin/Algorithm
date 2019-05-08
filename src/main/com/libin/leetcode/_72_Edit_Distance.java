package libin.leetcode;

/**
 * Copyright (c) 2019/04/22. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 给定2个单词，输出最小操作数是的一个单词可以变成另外一个单词。 操作分为：插入、删除、替换。
 * <p>
 * 如果只是增加或删除，那么可以用最长公共子序列来解，len1+len2-2*公共子序列长度。
 * <p>
 * 编辑距离
 * 定义状态：dp[i][j] 表示第一个串的第i个位置与第二个串的第j个位置之前需要操作几次可以到达。
 * 有3种状态：
 * 1、删除第一个串的一个字符到状态dp[i-1][j]
 * 2、删除第二个串的一个字符到状态dp[i][j-1]
 * 3、替换一个字符使得两个字符相等
 * <p>
 * if(word1[i]==word2[j]) dp[i][j]=dp[i-1][j-1]
 * if(word1[i]!=word2[j]) dp[i][j]=min(dp[i-1][j-1],min(dp[i-1][j],dp[i][j-1]))+1
 */
public class _72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= w1.length; i++) dp[i][0] = i;
        for (int j = 0; j <= w2.length; j++) dp[0][j] = j;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (w1[i - 1] == w2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                System.out.print(dp[i][j] + "、");
            }
            System.out.println();
        }
        return dp[w1.length][w2.length];
    }
}
