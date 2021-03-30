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
     * @param array 输入的数组
     * @return 返回最大连续子数组和
     */
    int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int maxNum = 0;
        int tmpNum = array[0];
        int minNum = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (minNum < array[i]) {
                minNum = array[i];
            }
            if (tmpNum < 0) {
                tmpNum = array[i];
            } else {
                tmpNum += array[i];
            }
            if (maxNum < tmpNum) {
                maxNum = tmpNum;
            }
        }
        if (minNum < 0) {  // 对于数组全是负数处理方法
            return minNum;
        }
        return maxNum;
    }
}
