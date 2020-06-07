# coding:utf-8
'''
1446. 连续字符
给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。

请你返回字符串的能量。

示例 1：

输入：s = "leetcode"
输出：2
解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
示例 2：

输入：s = "abbcccddddeeeeedcba"
输出：5
解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
示例 3：

输入：s = "triplepillooooow"
输出：5
示例 4：

输入：s = "hooraaaaaaaaaaay"
输出：11
示例 5：

输入：s = "tourist"
输出：1

'''


def maxPower(s):
    if not s:
        return 0
    if len(s) == 1:
        return 1
    list1 = []
    j = 0
    tag = 0
    for i in range(len(s)):
        # print(s[j], s[i],list1)
        if s[i] == s[j]:
            tag += 1
        else:
            list1.append(tag)
            tag = 1
            j = i
        if i == len(s)-1 and s[i]==s[j]:
            list1.append(tag)

    return max(list1)



s = 'ccc'
print(maxPower(s))
