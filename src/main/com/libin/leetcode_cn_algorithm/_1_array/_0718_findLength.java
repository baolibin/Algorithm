package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/3/29. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 */
public class _0718_findLength {
    // 最长公共字串(连续)
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        // dp[i][j]，代表的 x 的前 i 个字符串与 y 的 前 j 个字符串的最长公共子串
        int[][] dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                }
            }
        }
        return maxLen;
    }
}
