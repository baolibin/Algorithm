package libin.leetcode;

/**
 * Copyright (c) 2020/02/12. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 最大子数组乘积，f[i]表示[0,i]内包含num[i]的最大的子数组乘积
 */
public class _152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = res;
        g[0] = res;
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            res = Math.max(Math.max(f[i], g[i]), res);
        }
        return res;
    }
}
