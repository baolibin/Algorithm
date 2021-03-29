package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/3/28. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class _0560_subarraySum {
    int subarraySum(int[] nums, int k) {
        int count = 0, left = 0, right = 0;
        int sum = 0;
        while (left <= right && right < nums.length) {
            if (sum == k) {
                count++;
                sum -= nums[left++];
            } else if (sum < k) {
                sum += nums[right++];
            } else {
                sum -= nums[left++];
            }
        }
        return count;
    }
}
