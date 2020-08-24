# coding:utf-8
'''
面试题 17.10. 主要元素
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：

输入：[1,2,5,9,5,9,5,5,5]
输出：5


示例 2：

输入：[3,2]
输出：-1


示例 3：

输入：[2,2,1,1,1,2,2]
输出：2
'''


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        dict1 = {}
        for each in nums:
            if each not in dict1:
                dict1[each] = 1
            else:
                dict1[each] += 1
        for key in dict1:
            if dict1[key] > len(nums) // 2:
                return key
        return -1
