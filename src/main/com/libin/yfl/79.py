# coding:utf-8
'''
459. 重复的子字符串
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
'''


class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        if not s or len(s) == 1:
            return False
        for i in range(1, len(s)):
            result = s[:i]
            len_1 = len(result)
            if result * (len(s) // len_1) == s:
                return True
        return False
