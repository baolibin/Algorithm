# coding:utf-8
'''
50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数。
示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

'''
class Solution:
    def fenzhi_pow(self, x1, n1):
        if n1 == 1:
            return x1
        if n1 % 2 == 0:
            half = self.fenzhi_pow(x1, n1 // 2)
            return half * half
        else:
            half = self.fenzhi_pow(x1, n1 // 2)
            return half * half * x1
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        if n < 0:
            n = -n
            x = 1 / x
        return self.fenzhi_pow(x, n)
