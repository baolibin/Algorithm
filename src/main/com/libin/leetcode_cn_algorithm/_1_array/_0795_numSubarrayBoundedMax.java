package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/3/30. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 795. 区间子数组个数
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 */

public class _0795_numSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        // 最大值小于等于R的子数组个数 减去 最大值小于等于L-1的子数组个数
        return countSubArr(A, R) - countSubArr(A, L - 1);
    }

    /**
     * countSubArr(K) 表示所有元素都小于等于K的子数组数量。
     */
    private int countSubArr(int[] A, int K) {
        int count = 0;
        // dp[i]表示以i结尾的子数组,满足最大值 <= K的子数组个数
        int[] dp = new int[A.length + 1];
        dp[0] = A[0] <= K ? 1 : 0;
        count += dp[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = A[i] <= K ? dp[i - 1] + 1 : 0;
            count += dp[i];
        }
        return count;
    }
}
