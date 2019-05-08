package libin.leetcode;

/**
 * Copyright (c) 2019/04/02. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 从第0阶或第一阶出发，走完这个楼梯的最下成本是多少
 */
public class _746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        if (cost.length <= 2) {
            return 0;
        }
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
