'''
15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
'''


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = []
        if len(nums) < 3:
            return []
        nums.sort()
        n = len(nums)
        for i in range(len(nums) - 2):
            if nums[i] > 0:
                break
            left, right = i + 1, n - 1
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            while left < right:
                s = nums[i] + nums[left] + nums[right]
                if s < 0:
                    left += 1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                elif s > 0:
                    right = right - 1
                    while left < right and nums[right] == nums[right + 1]:
                        right = right - 1
                else:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right = right -1
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right = right - 1
        return result
