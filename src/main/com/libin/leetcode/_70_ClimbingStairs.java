package libin.leetcode;

/**
 * Copyright (c) 2019/04/22. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 一个台阶,一次可以走1步或者2步，求走n阶台阶有多少种不同的走法。
 */
public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
