package libin.Cracking_the_Coding_Interview;

/**
 * Copyright (c) 2020/4/11. libin Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :    面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: false
 * <p>
 * 示例 2：
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 */
public class _0101_isUnique {
    public boolean isUnique(String astr) {
        char[] c = astr.toCharArray();
        // 一遍for循环，判断每个字符下标是否是，字符串中和自己相等最后的下标
        for (int i = 0; i < c.length; i++) {
            if (i != astr.lastIndexOf(c[i])) {
                return false;
            }
        }
        return true;
    }
}
