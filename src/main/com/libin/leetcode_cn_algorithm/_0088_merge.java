package libin.leetcode_cn_algorithm;

/**
 * Copyright (c) 2020/4/12. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class _0088_merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        m--;
        n--;
        while (n >= 0 || m >= 0) {
            if (n >= 0 && m >= 0) {  // 两个数组都不为空情况
                if (nums1[m] > nums2[n]) {
                    nums1[--len] = nums1[m--];
                } else {
                    nums1[--len] = nums2[n--];
                }
            } else if (n >= 0) {  // nums1不为空情况
                nums1[--len] = nums2[n--];
            } else {  // nums2不为空情况
                nums1[--len] = nums1[m--];
            }
        }
    }
}
