package libin.leetcode_cn_algorithm._1_array;

/**
 * Copyright (c) 2021/3/28. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 乘积小于K的子数组
 * 给定一个正整数数组 nums。
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * 示例 1:
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */
public class _0713_numSubarrayProductLessThanK {
    // 维护一个乘积小于K的滑动窗口,窗口边界左右2个指针滑动
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, left = 0, right = 0;
        int target = 1;
        while (right < nums.length) {
            target *= nums[right++];
            while (target >= k && left < right) {
                target /= nums[left++];
            }
            count += (right - left);
        }
        return count;
    }
}
