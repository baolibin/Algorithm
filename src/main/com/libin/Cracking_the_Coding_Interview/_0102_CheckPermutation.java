package libin.Cracking_the_Coding_Interview;

/**
 * Copyright (c) 2020/4/18. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class _0102_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        // 异或操作：0^0=0， 1^0=1， 0^1=1， 1^1=0
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int res = 0;
        for (int i = 0; i < c1.length; i++) {
            res ^= c1[i] ^ c2[i];
        }
        return res == 0;
    }
}
