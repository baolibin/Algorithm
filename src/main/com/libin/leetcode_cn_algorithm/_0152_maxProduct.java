package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/5/14. 小彬科技 Inc. All Rights Reserved.
 * Authors: libin <小彬科技>
 * <p>
 * Purpose : 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class _0152_maxProduct {
    public int maxProduct(int[] nums) {
        int[] maxNum = new int[nums.length];
        int[] minNum = new int[nums.length];
        maxNum[0] = nums[0];
        minNum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNum[i] = Math.max(nums[i], Math.max(maxNum[i - 1] * nums[i], minNum[i - 1] * nums[i]));
            minNum[i] = Math.min(nums[i], Math.min(maxNum[i - 1] * nums[i], minNum[i - 1] * nums[i]));
            max = Math.max(max, Math.max(maxNum[i], minNum[i]));
        }
        return max;
    }
}
