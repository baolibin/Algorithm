package libin.leetcode_cn_algorithm._1_array;

import java.util.HashSet;

/**
 * Copyright (c) 2021/4/1. libin Inc. All Rights Reserved.
 * Authors: libin <libin>
 * <p>
 * Purpose : 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class _0219_containsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (i > k - 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
