'''
88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
'''


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

        for i in range(len(nums2)):
            nums1[i + m] = nums2[i]
        nums1 = nums1.sort()


# 下面的方法也可以实现功能，但是提交不通过，本题是要不改变nums1的前提下通过，且不需要return语句
def merge(nums1, m, nums2, n):
    """
    Do not return anything, modify nums1 in-place instead.
    """
    nums1 = nums1[:m]
    for i in range(len(nums2)):
        # print(nums1)
        for j in range(len(nums1)):
            if nums2[i] == 'False':
                continue
            if nums2[i] <= nums1[j]:
                nums1.insert(j, nums2[i])
                nums2[i] = 'False'
                break
        if nums2[i] != 'False':
            nums1.append(nums2[i])
    return nums1
