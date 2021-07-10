package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class _0053_maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (maxSum < dp[i]) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }

    /**
     * 贪心法
     *
     * @param nums 输入的数组
     * @return 返回最大连续子数组和
     */
    int FindGreatestSumOfSubArray(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int curCount = 0;
        for (int i = 0; i < nums.length; i++) {
            curCount += nums[i];
            maxNum = Math.max(curCount,maxNum);
            if (curCount < 0) {
                curCount = 0;
            }
        }
        return maxNum;
    }
}
