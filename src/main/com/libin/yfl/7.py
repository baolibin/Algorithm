'''
290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false
说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
'''
class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        l1 = list(pattern)
        l2 = str.split()
        dict1 = {}
        if len(l1) != len(l2):
            return False
        for i in range(len(l1)):
            if l1[i] not in dict1:
                dict1[l1[i]] = l2[i]
            else:
                if dict1[l1[i]] != l2[i]:
                    return False
        if len(list(set(dict1.values()))) != len(dict1.values()):
            return False
        return True