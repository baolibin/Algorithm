'''
面试题 16.07. 最大数值
编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

示例：

输入： a = 1, b = 2
输出： 2
'''
class Solution:
    def maximum(self, a: int, b: int) -> int:
        return ((a+b)+abs(a-b)) // 2