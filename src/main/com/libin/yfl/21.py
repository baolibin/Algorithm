# coding:utf-8
'''
3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
'''


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        if len(list(set(list(s)))) == 1:
            return 1
        dict1 = {}
        for i in range(len(s)):
            str1 = s[i]
            tag = 0
            for j in range(i + 1, len(s)):
                if s[j] not in str1:
                    str1 = str1 + s[j]
                else:
                    if str1 not in dict1:
                        dict1[str1] = len(str1)
                    tag = 1
                    break
            if tag == 0:
                dict1[str1] = len(str1)
        list1 = dict1.values()
        max1 = 0
        for each in list1:
            if each > max1:
                max1 = each
        return max1

