''''
面试题50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
示例:
s = "abaccdeff"
返回 "b"
s = ""
返回 " "
'''
class Solution:
    def firstUniqChar(self, s: str) -> str:
        d1 = {}
        for each in s:
            if each not in d1:
                d1[each] = 1
            else:
                d1[each] += 1
        for key in s:
            if d1[key] == 1:
                return key
        return ' '