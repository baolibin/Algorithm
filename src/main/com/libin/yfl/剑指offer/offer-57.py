# coding:utf-8
'''
题目：剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]

提示：
等差数列求和
'''


class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        if target <= 2:
            return []
        res = []
        for i in range(2, target + 1):
            linshi = target - i * (i - 1) // 2
            if linshi <= 0:
                break
            if not linshi % i:
                start = linshi // i
                res.append([start+j for j in range(i)])
        return res[::-1]
