# coding:utf-8
'''
面试题 01.05. 一次编辑
字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
示例 1:
输入:
first = "pale"
second = "ple"
输出: True
示例 2:
输入:
first = "pales"
second = "pal"
输出: False

'''
class Solution:
    def oneEditAway(self, first: str, second: str) -> bool:
        if abs(len(list(first))-len(list(second))) > 1:
            return False
        flag = 0
        if len(list(first)) == len(list(second)):
            for i in range(len(first)):
                if first[i] != second[i]:
                    flag += 1
                if flag > 1:
                    return False
            return True
        else:
            min_ = first if len(first) == min(len(first),len(second)) else second
            max_ = first if min_== second else second
            linshi = min_
            if max_.find(min_) != -1:
                return True
            for j in range(len(max_)):
                if linshi[j] != max_[j]:
                    flag += 1
                    linshi = linshi[:j]+max_[j]+linshi[j:]
                if flag > 1:
                    return False
            return True
