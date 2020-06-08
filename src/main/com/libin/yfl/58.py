# coding:utf-8
'''
443. 压缩字符串
给定一组字符，使用原地算法将其压缩。
压缩后的长度必须始终小于或等于原数组长度。
数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
在完成原地修改输入数组后，返回数组的新长度。
进阶：
你能否仅使用O(1) 空间解决问题？
示例 1：
输入：
["a","a","b","b","c","c","c"]
输出：
返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
说明：
"aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
示例 2：
输入：
["a"]
输出：
返回1，输入数组的前1个字符应该是：["a"]
说明：
没有任何字符串被替代。
示例 3：
输入：
["a","b","b","b","b","b","b","b","b","b","b","b","b"]
输出：
返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
说明：
由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
注意每个数字在数组中都有它自己的位置。
'''


def compress(chars) -> int:
    if not chars:
        return []
    if len(chars) == 1:
        return chars
    list1 = []
    j = 0
    tag = 0
    for i in range(len(chars)):
        if chars[i] == chars[j]:
            tag += 1
        else:
            if tag == 1:
                list1.append(chars[i - 1])
            else:
                list1.append(chars[i - 1] + str(tag))
            tag = 1
            j = i
        if i == len(chars) - 1 and chars[i] == chars[j]:
            if tag == 1:
                list1.append(chars[i - 1])
            else:
                list1.append(chars[i - 1] + str(tag))
    return len(list(''.join(list1)))



class Solution(object):
    def compress(self, chars):
        anchor = write = 0
        for read, c in enumerate(chars):
            if read + 1 == len(chars) or chars[read + 1] != c:
                chars[write] = chars[anchor]
                write += 1
                if read > anchor:
                    for digit in str(read - anchor + 1):
                        chars[write] = digit
                        write += 1
                anchor = read + 1
        return write
