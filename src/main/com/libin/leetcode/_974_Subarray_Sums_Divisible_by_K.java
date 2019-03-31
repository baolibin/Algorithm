package libin.leetcode;

import java.util.ArrayList;

/**
 * Copyright (c) 2019/03/25. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 在一个数组中，有多少个连续子数组的和，恰好可以被K整除
 */
public class _974_Subarray_Sums_Divisible_by_K {
    public int subarraysDivByK(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            sum[i] = A[i - 1] + sum[i - 1];
        }
        int count = 0;
        int[] dp = new int[A.length+1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((sum[i] - sum[j]) % K == 0) {
                    dp[i] = dp[j] + 1;
                    count += dp[i];
                    break;
                }
            }
        }
        return count;
    }
}
