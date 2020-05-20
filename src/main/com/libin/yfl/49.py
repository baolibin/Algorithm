# coding:utf-8
'''
917. 仅仅反转字母
给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
示例 1：

输入："ab-cd"
输出："dc-ba"
示例 2：

输入："a-bC-dEf-ghIj"
输出："j-Ih-gfE-dCba"
示例 3：

输入："Test1ng-Leet=code-Q!"
输出："Qedo1ct-eeLg=ntse-T!"
'''
import re

class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        result = ''.join(re.findall(r'[A-Za-z]', S))
        list1 = []
        for each in S:
            if each.isalpha():
                list1.append('')
            else:
                list1.append(each)
        tag = 0
        for i in range(len(list1)):
            e = list1[i]
            if not e:
                tag += 1
                list1[i] = result[-tag]
        return ''.join(list1)