'''
1163. 按字典序排在最后的子串
给你一个字符串 s，找出它的所有子串并按字典序排列，返回排在最后的那个子串。

示例 1：

输入："abab"
输出："bab"
解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
示例 2：

输入："leetcode"
输出："tcode"
'''


class Solution:
    def lastSubstring(self, s: str) -> str:
        return max(s[i:] for i in range(len(s)))


def lastSubstring(s: str) -> str:
    list1 = []
    for i in range(len(s)):
        list1.append(s[i:])
    print(list1)
    print(max(list1))
    return max(s[i:] for i in range(len(s)))


lastSubstring('abab')
