package libin.Cracking_the_Coding_Interview;

/**
 * Copyright (c) 2020/4/24. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 面试题 17.10. 主要元素
 * 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 * <p>
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class _1710_majorityElement {
    public int majorityElement(int[] nums) {
        int primary = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (primary == nums[i]) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    primary = nums[i];
                    count = 1;
                }
            }
        }
        return primary;
    }
}
