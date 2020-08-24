'''
984. 不含 AAA 或 BBB 的字符串
给定两个整数 A 和 B，返回任意字符串 S，要求满足：

S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
子串 'aaa' 没有出现在 S 中；
子串 'bbb' 没有出现在 S 中。


示例 1：

输入：A = 1, B = 2
输出："abb"
解释："abb", "bab" 和 "bba" 都是正确答案。
示例 2：

输入：A = 4, B = 1
输出："aabaa"
'''


class Solution:
    def strWithout3a3b(self, A: int, B: int) -> str:
        if A == B:
            return "ab" * A

        ans = ""
        la = A
        lb = B
        while la > 0 and lb > 0:
            if la > lb:
                ans += "aab"
                la -= 2
                lb -= 1
            elif la < lb:
                ans += "bba"
                la -= 1
                lb -= 2
            else:
                if A > B:
                    ans += "ab" * la
                else:
                    ans += "ba" * la
                la = 0
                lb = 0

        if A > B:
            ans += "a" * la + "b" * lb
        else:
            ans += "b" * lb + "a" * la

        return ans
