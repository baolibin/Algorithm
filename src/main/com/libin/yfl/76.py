# coding:utf-8
'''
97. 交错字符串
给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。

示例 1:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出: true
示例 2:

输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出: false
'''


def isInterleave(s1: str, s2: str, s3: str) -> bool:
    tag = 0
    str1 = ''
    if not s1:
        return False
    if not s2:
        return False
    if not s3:
        return False
    for i in range(len(s1)):
        flag = 0
        for j in range(tag, len(s3)):
            if s3[j] == s1[i]:
                tag = j + 1
                flag = 1
                break
            else:
                str1 = str1 + s3[j]
        if flag == 0:
            return False
    if tag < len(s3) - 1:
        str1 = str1 + s3[tag:]
    tag = 0
    print(str1)
    for i in range(len(s2)):
        flag = 0
        for j in range(tag, len(s3)):
            if s3[j] == s2[i]:
                tag = j + 1
                flag = 1
                break
        if flag == 0:
            return False
    return True


s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbcbcac"
print(isInterleave(s1, s2, s3))
