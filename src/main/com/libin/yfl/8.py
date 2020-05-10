'''
219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
'''
# 下面代码会报超出时间限制
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        for i in range(len(nums)):
            for m in range(k):
                if i+m+1 < len(nums):
                    if nums[i] == nums[i+m+1]:
                        return True
        return False
# 下面的代码通过，for循环使用的少可以减少运行时间
class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dict1 = {}
        for i in range(len(nums)):
            if nums[i] in dict1:
                if i-dict1[nums[i]] <= k:
                    return True
            dict1[nums[i]] = i
        return False
