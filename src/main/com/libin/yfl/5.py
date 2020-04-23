'''
面试题11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
示例 1：
输入：[3,4,5,1,2]
输出：1
示例 2：
输入：[2,2,2,0,1]
输出：0
'''
# 自己的代码
class Solution:
    def minArray(self, numbers: List[int]) -> int:
        return min(numbers)
# 大神的代码：二分查找
class Solution:
    def minArray(self, numbers: List[int]) -> int:
        if not numbers: return
        start, end = 0, len(numbers) - 1
        while start < end:
            middle = (start + end) // 2
            if numbers[middle] > numbers[end]: start = middle + 1
            elif numbers[middle] < numbers[end]: end = middle
            # 其实这个end-=1很巧妙，因为相等的时候我们无法判断要往哪个方向缩小
            # 所以索性就缩小numbers的长度。
            else: end -= 1
        return numbers[start]
